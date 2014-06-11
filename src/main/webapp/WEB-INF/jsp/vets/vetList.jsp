<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">


<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Veterinarians</h2>

    <datatables:table id="vets" data="${vets.vetList}" cdn="true" row="vet" theme="bootstrap2" cssClass="table table-striped" paginate="false" info="false">
        <datatables:column title="Name">
            <c:out value="${vet.firstName} ${vet.lastName}"></c:out>
        </datatables:column>
        <datatables:column title="Specialties">
            <c:forEach var="specialty" items="${vet.specialties}">
                <c:out value="${specialty.name}"/>
            </c:forEach>
            <c:if test="${vet.nrOfSpecialties == 0}">none</c:if>
        </datatables:column>
        <datatables:column title="Days">
               <c:out value="${vet.days}"></c:out>
        </datatables:column>
        <datatables:column title="Email" cssStyle="width: 150px;" display="html">
               <spring:url value="/vet/{vetId}/email" var="vetUrl" >
                             <spring:param name="vetId" value="${vet.id}"/>

               </spring:url>
               <a href="${fn:escapeXml(vetUrl)}" alt="Sponsored by Aspose"><c:out value="${vet.email}" /></a>
        </datatables:column>

    </datatables:table>
    


            <td align="right">
            <img src="<spring:url value="/resources/images/aspose/asposeSmall.png" htmlEscape="true" />"alt="Sponsored by Aspose"/>
            <b>Export To:</b>
            </td>
            </tr>
            </table>

            <table>

                <tr>
                    <td><a href='<spring:url value="/vets/pdf/export" htmlEscape="true"/>'>
                    <img src="<spring:url value="/resources/images/aspose/aspose_pdf-for-java.jpg" htmlEscape="true" />"
                                                   alt="Sponsored by Aspose"/></a></td>
    <td><a href='<spring:url value="/vets/words/export" htmlEscape="true"/>'>
                    <img src="<spring:url value="/resources/images/aspose/aspose_words-for-java.jpg" htmlEscape="true" />"
                                                   alt="Sponsored by Aspose"/></a></td>
    <td><a href='<spring:url value="/vets/cells/export" htmlEscape="true"/>'>
                    <img src="<spring:url value="/resources/images/aspose/aspose_cells-for-java.jpg" htmlEscape="true" />"
                                                   alt="Sponsored by Aspose"/></a></td>
                </tr>
            </table>
            </br>

    <table class="table-buttons">
        <tr>

            <td>
                <a href="<spring:url value="/vets.xml" htmlEscape="true" />">View as XML</a>
            </td>


        </tr>
        <tr>
         <td>
                        <a href="<spring:url value="/vets.atom" htmlEscape="true" />">Subscribe to Atom feed</a>
                    </td>
                    </tr>
    </table>

     <tr>

    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
