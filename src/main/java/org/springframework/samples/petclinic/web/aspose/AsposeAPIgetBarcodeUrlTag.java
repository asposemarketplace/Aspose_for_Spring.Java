package org.springframework.samples.petclinic.web.aspose;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
public class AsposeAPIgetBarcodeUrlTag extends SimpleTagSupport implements AsposeAPIConfiguration {

    private String symbology;
    private String billamount;
    private String varName;
    private String scopeName;

    public void setSymbology( String symbology ) { this.symbology = symbology; }
    public void setBillAmount( String billamount ) { this.billamount = billamount; }
    public void setVar( String value ) { this.varName = value; }
    public void setScope( String value ) { this.scopeName = value; }

    public void doTag() throws JspException {
        try {
          ScopedContext scopedContext = (this.scopeName == null) ?
              ScopedContext.PAGE : ScopedContext.getInstance( this.scopeName );
          Object constantValue =  getSymbologyValue( BarcodeTypeConstantClass+"."+this.symbology );
            constantValue= ServletUriComponentsBuilder.fromCurrentContextPath().path(BarcodeServiceURL+billamount+"/"+constantValue).build().toUriString();
          getJspContext().setAttribute(this.varName,
                  constantValue,
                  scopedContext.getValue());
        }
        catch (Exception e) {
            throw new JspException( "Exception setting constant " +
                                    this.symbology, e );
        }
    }



    public Object getSymbologyValue(String Symbology)
            throws IllegalAccessException, InstantiationException,ClassNotFoundException, NoSuchFieldException
    {
        Field field;
        FieldPathParser parser = new FieldPathParser(Symbology);
        field = Class.forName(parser.getDeclaringClassName()).getField(parser.getFieldName());
        if ((!Modifier.isPublic(field.getModifiers())) || (!Modifier.isStatic(field.getModifiers())) || (!Modifier.isFinal(field.getModifiers()))) {
            throw new IllegalArgumentException( Symbology + " is not a public static final member");
        }

        return field.get(null);
    }

}