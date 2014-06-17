/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.*;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.aspose.AsposeAPI;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Adeel Ilyas  (For Parts of Aspose APIs for Java, Spring Integration)
 */

@Controller
@SessionAttributes(types={Vets.class,EmailForm.class})
public class VetController {

    private final ClinicService clinicService;


    @Autowired
    public VetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping("/vets")
    public String showVetList(Map<String, Object> model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects 
        // so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        model.put("vets", vets);
        return "vets/vetList";
    }

 /*
 * Project Extension Name: Aspose for Spring Java (petclinic)
 *
 * @author: Adeel Ilyas
 * Company: Aspose Pty Ltd.
 *
 * Date: 4/6/2014
 *
 * Detail:
 * This Extension was written to showcase the usage of Aspose APIs for Java
 * (Aspose.Word, Aspose.PDF, Aspose.Cells,Aspose.Email, Aspose Barcode)
 * for Spring, Spring MVC Java Developers.
 */

    @RequestMapping(value = "/vets/{typeFile}/export", method = RequestMethod.GET)
    public void processExport(@PathVariable("typeFile") String typeFile,Vets vets,HttpServletResponse response, HttpServletRequest req) {


        if (vets.getVetList().size()<1) {
            vets = new Vets();
            vets.getVetList().addAll(this.clinicService.findVets());
        }


        //tell browser program going to return an data file
        //instead of html page

        if (typeFile.equals("pdf")) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition","attachment;filename=AsposeExportVets.pdf");
        } else  if (typeFile.equals("cells")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition","attachment;filename=AsposeExportVets.xlsx");
        } else  if (typeFile.equals("words")) {
            response.setContentType("application/msword");
            response.setHeader("Content-Disposition","attachment;filename=AsposeExportVets.doc");
        }

        try {
            ServletOutputStream out = response.getOutputStream();
            if (typeFile.equals("pdf")) {
                AsposeAPI.generateVetsAsposePDF(out, vets,req.getServletContext());
            } else  if (typeFile.equals("cells")) {
                AsposeAPI.generateVetsAsposeCells(out, vets,req.getServletContext());
            } else  if (typeFile.equals("words")) {
                AsposeAPI.generateVetsAsposeWords(out, vets,req.getServletContext());
            }

            out.close();

        } catch (Exception io) {
          io.printStackTrace();
        }

    }

    @RequestMapping(value = "/vet/{vetId}/email", method = RequestMethod.GET)
    public String initEmailVetForm(@PathVariable("vetId") int vetId,Map<String, Object> model) {
        Vet vet = this.clinicService.findVetById(vetId);
        EmailForm emailform = new EmailForm();
        emailform.setEmail(vet.getEmail());
        emailform.setSubject("Consultation");
        emailform.setFirstName(vet.getFirstName());
        emailform.setLastName(vet.getLastName());
        System.out.println(emailform.getFirstName()+" "+emailform.getLastName());
        model.put("emailform", emailform);
        return "vets/emailVet";
    }

    @RequestMapping(value = "/vet/{vetId}/email",method = {RequestMethod.PUT, RequestMethod.POST})
    public String processEmailVetForm(@ModelAttribute("emailform") EmailForm emailform,BindingResult result, SessionStatus status,HttpServletResponse response) {
        new EmailFormValidator().validate(emailform, result);
        if (result.hasErrors()) {
           return "vets/emailVet";
        } else {
            try {
                ServletOutputStream out = response.getOutputStream();
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition","attachment;filename="+emailform.getFirstName()+ UUID.randomUUID()+".msg");
                AsposeAPI.asposeEmail(emailform.getFirstName()+" "+emailform.getLastName(),emailform.getEmail(),emailform.getFrom(),emailform.getSubject(),emailform.getMessage(),out);
                out.flush();
                out.close();


                System.out.println("Message Sent: " + emailform.getMessage());
                //status.setComplete();


            } catch (IOException io) {

            }
            return "redirect:/vets";
        }
    }

}
