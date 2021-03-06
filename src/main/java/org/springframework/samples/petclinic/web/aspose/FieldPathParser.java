package org.springframework.samples.petclinic.web.aspose;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Project Extension Name: Aspose Java for Spring Java (petclinic)
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

public class FieldPathParser
{
private static final String REGEX_FIELD_PATH = "((\\w+\\.)+)(\\w+)";
private static final int GROUP_INDEX_CLASS = 1;
private static final int GROUP_INDEX_FIELD = 3;
private String className;
private String fieldName;

public FieldPathParser(String path)
{
Matcher matcher = Pattern.compile("((\\w+\\.)+)(\\w+)").matcher(path);
matcher.find();
this.className = matcher.group(1);
this.className = this.className.substring(0, this.className.length() - 1);
this.fieldName = matcher.group(3);
}

public String getDeclaringClassName()
{
return this.className;
}

public String getFieldName()
{
return this.fieldName;
}
}