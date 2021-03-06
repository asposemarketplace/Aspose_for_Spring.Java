package org.springframework.samples.petclinic.web.aspose;

/**
 * Created by Adeel Ilyas on 6/9/2014.
 */
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

public interface AsposeAPIConfiguration {

    public static final String BarcodeServiceURL = "/asposeapi/barcode/";

    public static final String BarcodeSpringMVCRequestMapping ="/asposeapi/barcode/{billAmount}/{symbology}";

    public static final String BarcodeTypeConstantClass="com.aspose.barcode.Symbology";
}

