<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib uri="/WEB-INF/tags/aspose/AsposeAPI.tld" prefix="aspose" %>
<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>


<body>
<script>
    $(function () {
        $("#date").datepicker({ dateFormat: 'yy/mm/dd'});
          //attach keypress to input
                  $('.numeric').keydown(function(event) {
                      // Allow special chars + arrows
                      if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9
                          || event.keyCode == 27 || event.keyCode == 13
                          || (event.keyCode == 65 && event.ctrlKey === true)
                          || (event.keyCode >= 35 && event.keyCode <= 39)){
                              return;
                      }else {
                          // If it's not a number stop the keypress
                          if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
                              event.preventDefault();
                          }
                      }
                  });
    });
</script>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2><c:if test="${visit['new']}">New </c:if>Visit</h2>

    <b>Pet</b>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Birth Date</th>
            <th>Type</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tr>
            <td><c:out value="${visit.pet.name}"/></td>
            <td><joda:format value="${visit.pet.birthDate}" pattern="yyyy/MM/dd"/></td>
            <td><c:out value="${visit.pet.type.name}"/></td>
            <td><c:out value="${visit.pet.owner.firstName} ${visit.pet.owner.lastName}"/></td>
        </tr>
    </table>

    <form:form modelAttribute="visit">
        <div class="control-group">
            <label class="control-label">Date </label>

            <div class="controls">
                <form:input path="date"/>
                <span class="help-inline"><form:errors path="date"/></span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">Description </label>

            <div class="controls">
                <form:input path="description"/>
                <span class="help-inline"><form:errors path="description"/></span>
            </div>
        </div>
          <div class="control-group">
                    <label class="control-label">Bill Amount </label>

                    <div class="controls">
                        <form:input path="billAmount"  class="numeric"/>
                        <span class="help-inline"><form:errors path="billAmount"/></span>
                    </div>
                </div>
        <div class="form-actions">
            <input type="hidden" name="petId" value="${visit.pet.id}"/>
            <button type="submit">Add Visit</button>
        </div>
    </form:form>

    <br/>
    <b>Previous Visits</b>
    <table style="width: 333px;">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>BillAmount</th>
        </tr>
        <c:forEach var="visit" items="${visit.pet.visits}">
            <c:if test="${!visit['new']}">
                <tr>
                    <td><joda:format value="${visit.date}" pattern="yyyy/MM/dd"/></td>
                    <td><c:out value="${visit.description}"/></td>

                    <td>
                    <aspose:getBarcodeUrl symbology="QR" billAmount="${visit.billAmount}"
                                                 var="barcodeUrl"/>
                    <img src="${barcodeUrl}" alt="Sponsored by Aspose"/>
			         </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
