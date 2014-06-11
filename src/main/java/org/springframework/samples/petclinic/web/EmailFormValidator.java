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
/*
 * Project Extension Name: Aspose for Spring Java (petclinic)
 *
 * @author: Adeel Ilyas
 * Company: Aspose Pte Ltd.
 *
 * Date: 4/6/2014
 *
 * Detail:
 * This Extension was written to showcase the usage of Aspose APIs for Java
 * (Aspose.Word, Aspose.PDF, Aspose.Cells,Aspose.Email, Aspose Barcode)
 * for Spring, Spring MVC Java Developers.
 */
package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.model.EmailForm;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Project Extension Name: Aspose for Spring Java (petclinic)
 *
 * @author: Adeel Ilyas
 * Company: Aspose Pte Ltd.
 *
 * Date: 4/6/2014
 *
 * Detail:
 * This Extension was written to showcase the usage of Aspose APIs for Java
 * (Aspose.Word, Aspose.PDF, Aspose.Cells,Aspose.Email, Aspose Barcode)
 * for Spring, Spring MVC Java Developers.
 */
/**
 * <code>Validator</code> for <code>EmailForm</code> forms.
 *
 *
 */

public class EmailFormValidator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    public void validate(EmailForm emailform, Errors errors) {
        String from = emailform.getFrom();
        // from field validation
        if (!StringUtils.hasLength(from)) {
            errors.rejectValue("from", "required", "required");
        } else {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(from);
            if (!matcher.matches()) {
                errors.rejectValue("from", "email.incorrect",
                        "Enter a correct email");
            }
        }
        String subject = emailform.getSubject();
        // subject field validation
        if (!StringUtils.hasLength(subject)) {
            errors.rejectValue("subject", "required", "required");
        }
     
    }

}
