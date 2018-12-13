<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<form:form method="post" action="addFlight" modelAttribute="params">
	<table>
		<tr>
		<td><form:label path="departureLocation">Enter Departure Location :</form:label></td>
		<td><form:input path="departureLocation" /></td>
		<td><form:errors path="departureLocation" cssClass="error"/></td>
		</tr>
		<tr>
		<td><form:label path="arrivalLocation">Enter Arrival Location :</form:label></td>
		<td><form:input path="arrivalLocation" /></td>
		</tr>
		<%-- <tr>
		<td><form:label path="date">Select date :</form:label></td>
		<td><form:input path="date" id="datepicker" /></td>
		</tr> --%>
		<tr>
		<td><input type="submit" value="Search.."/>
		</td>
		</tr>
	</table>
</form:form>
</body>
</html>