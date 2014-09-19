package org.springframework.samples.petclinic.web.aspose;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLConnection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
 /*
 * Project Extension Name: Aspose Java for Spring Java (petclinic)
 *
 * @author: Adeel Ilyas (adeel.ilyas@aspose.com)
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
 * <code>AsposeFilter</code> for converting webpages to ms-word format.
 *
 *
 */

public class AsposeFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }
 
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    final HttpServletResponse response = (HttpServletResponse) servletResponse;
 
    final WrappedResponse.ByteArrayPrintWriter pw = new WrappedResponse.ByteArrayPrintWriter();
    HttpServletResponse wrappedResp = new HttpServletResponseWrapper(response) {
      public PrintWriter getWriter() {
        return pw.getWriter();
      }
 
      public ServletOutputStream getOutputStream() {
        return pw.getStream();
      }
 
    };
 
    filterChain.doFilter(servletRequest, wrappedResp);
 
    byte[] bytes = pw.toByteArray();
      response.getOutputStream().write(bytes);
      if (bytes.length>0) {

          String contentType = null;
          try {
              contentType = URLConnection.guessContentTypeFromStream(
                      new ByteArrayInputStream(bytes));
          } catch (IOException e) {
              System.out.println("Could not guess content type");
          }
          if (contentType!=null && contentType.equals("text/html")) {
              /* replacing something like "/petclinic/" with
              "http://localhost:9966/petclinic/"
              */
              final String webContext= servletRequest.getServletContext().getContextPath()+"/";
              String correctBytes = new String(bytes).replaceAll(webContext,servletRequest.getScheme()+"://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+webContext);
              ResponseHolder.setResponse(correctBytes.getBytes());
          }
      }
  }
 
  public void destroy() {}
 
}