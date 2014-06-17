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
package org.springframework.samples.petclinic.web.aspose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.samples.petclinic.model.CurrencyAmount;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

/**
 * @author Adeel Ilyas
 */
@Controller

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

/*
*
* Aspose Barcode Generator Action
*
* @author Adeel Ilyas
*
*/
public class AsposeAPIController implements AsposeAPIConfiguration {
    @Autowired
    private FormattingConversionService conversionService;

    @RequestMapping(value = BarcodeSpringMVCRequestMapping,method = RequestMethod.GET)
    public void getBarcode(@PathVariable Double billAmount,@PathVariable String symbology,HttpServletResponse response) {

            try {
                ServletOutputStream out = response.getOutputStream();
                response.setContentType("image/png");
              //  conversionService

                DataBinder binder = new DataBinder(new CurrencyAmount(billAmount));
                binder.setConversionService(conversionService);
                String codeText = binder.getBindingResult().getFieldValue("billAmount").toString();

                AsposeAPI.createAsposeBarCode(codeText, out,symbology);
                out.flush();
                out.close();


                System.out.println("BillAmount: " + billAmount);
                System.out.println("BillAmount (formatted): " + codeText);


            } catch (IOException io) {

            }


    }
}
