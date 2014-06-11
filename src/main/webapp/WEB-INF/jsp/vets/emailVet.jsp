<!DOCTYPE html>
<!--
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
 *
-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@
taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<html lang="en">

	<jsp:include page="../fragments/headTag.jsp" />

	<body>
		<div class="container">
			<jsp:include page="../fragments/bodyHeader.jsp" />

			<h2>Email Veterinarian</h2>

			<table class="table table-striped" style="width:600px;height:100px">
				<tr>
					<th style="padding-right: 40px">Name</th>
					<td>
						<b>
							<c:out value="${emailform.firstName} ${emailform.lastName}" />
						</b>
					</td>

				</tr>
				<tr>
					<th>Email</th>
					<td>
						<b>
							<c:out value="${emailform.email}" />
						</b>
					</td>
				</tr>
			</table>

			<form:form modelAttribute="emailform" method="put"
				class="form-horizontal" id="send-vet-email">


				<table
					style="width:600px;border-collapse: separate;border-spacing: 5px 0px;">
					<tr>
						<td>
							<petclinic:inputField label="From" name="from" />
						</td>
					</tr>
					<tr>
						<td>
							<petclinic:inputField label="Subject" name="subject" />
						</td>
					</tr>
					<tr>
						<td>
							<label class="control-label">Message </label>
							<div class="controls">
								<form:textarea path="message" rows="7" cols="30" />
						</td>


		</div>
	</tr>
		<tr>

			<td>
				<div class="form-actions">

					<button type="submit" class="btn btn-success" ">Send from
						OutLook</button>

				</div>
			</td>
		</tr>
	</table>
	</form:form>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
	</body>

</html>
