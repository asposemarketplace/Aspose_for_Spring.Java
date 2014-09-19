<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Owners</h2>

    <datatables:table id="owners" data="${selections}" cdn="true" row="owner" theme="bootstrap2"
                      cssClass="table table-striped" paginate="false" info="false">
        <datatables:column title="Name" cssStyle="width: 150px;" display="html">
            <spring:url value="/owners/{ownerId}.html" var="ownerUrl">
                <spring:param name="ownerId" value="${owner.id}"/>
            </spring:url>
            <a href="${fn:escapeXml(ownerUrl)}"><c:out value="${owner.firstName} ${owner.lastName}"/></a>
        </datatables:column>
        <datatables:column title="Name" display="pdf">
            <c:out value="${owner.firstName} ${owner.lastName}"/>
        </datatables:column>
        <datatables:column title="Address" property="address" cssStyle="width: 200px;"/>
        <datatables:column title="City" property="city"/>
        <datatables:column title="Telephone" property="telephone"/>
        <datatables:column title="Pets" cssStyle="width: 100px;">
            <c:forEach var="pet" items="${owner.pets}">
                <c:out value="${pet.name}"/>
            </c:forEach>
        </datatables:column>
    </datatables:table>

  <table>
        <tr>

        <td align="right">
        <img src="<spring:url value="/resources/images/aspose/asposeSmall.png" htmlEscape="true"/>"alt="Sponsored by Aspose"/>
        <b>Export To:</b>
        </td>
        </tr>
        </table>
        <table>

            <tr>
                <td><a href='<spring:url value="/owners/pdf/export" htmlEscape="true"/>'>
                <img src="<spring:url value="/resources/images/aspose/aspose_pdf-for-java.jpg" htmlEscape="true" />"
                                               alt="Sponsored by Aspose"/></a></td>
<td><a href='<spring:url value="/owners/words/export" htmlEscape="true"/>'>
                <img src="<spring:url value="/resources/images/aspose/aspose_words-for-java.jpg" htmlEscape="true" />"
                                               alt="Sponsored by Aspose"/></a></td>
<td><a href='<spring:url value="/owners/cells/export" htmlEscape="true"/>'>
                <img src="<spring:url value="/resources/images/aspose/aspose_cells-for-java.jpg" htmlEscape="true" />"
                                               alt="Sponsored by Aspose"/></a></td>

            </tr>
        </table>

    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
