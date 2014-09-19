
package org.springframework.samples.petclinic.web.aspose;

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
/**
 * Response holder that holds the current Response Html.
 * 
 * @author Adeel Ilyas
 * 
 */
public class ResponseHolder {

	/** The thread local. */
	private static byte[] bytes=null;

	/**
	 * Sets the response.
	 * 
	 * @param response
	 *            the new response
	 */
	public static void setResponse(byte[] response) {
        bytes = response;
	}

	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public static byte[] getResponse() {
		return bytes;
	}

}
