<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search Application</title>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<style type="text/css">
table, th, td {
	margin-left: 100px; border : 1px solid black;
	border-collapse: collapse;
	border: 1px solid black;
}

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div style="margin-top: 80px" align="center">
		<h2>Flight Search Page</h2>
		<form:form action="searchFlight" method="post"
			modelAttribute="flightSearchParameters">
			<spring:message code="lbl.departureLocation" />:
			<form:input path="departureLocation" />
			<small> &nbsp;(in 3 letter code)</small>
			<br />
			<form:errors path="departureLocation" cssClass="error" />
			<br />
			<br />
			<spring:message code="lbl.arrivalLocation" />:
			<form:input path="arrivalLocation" />
			<small> &nbsp; (in 3 letter code)</small>
			<br />
			<form:errors path="arrivalLocation" cssClass="error" />
			<br />
			<br />
			<spring:message code="lbl.date" />:
			<form:input path="date" id="datepicker" pattern="dd/MM/yyyy" />
			<br />
			<form:errors path="date" cssClass="error" />
			<br />
			<br />
			<spring:message code="lbl.flightClass" />:
			<form:select path="flightClass">
				<form:option label="Select Flight Class" value="" />
				<form:option label="Economic" value="E" />
				<form:option label="Business" value="B" />
			</form:select>
			<br />
			<form:errors path="flightClass" cssClass="error" />
			<br />
			<br />
			<spring:message code="lbl.outputPreference" />:
			<form:select path="outputPreference">
				<form:option label="Select Sort by" value="" />
				<form:option label="By Fare" value="F" />
				<form:option label="By Fare & Duration" value="FD" />
			</form:select>
			<br />
			<form:errors path="outputPreference" cssClass="error" />
			<br />
			<br />
			<input type="submit" value="Search Flights" />
			<input type="reset" value="Reset" />
		</form:form>

	</div>
	<br />
	<table>
		<tr>
			
				<th>Flight Number</th>
				<th>Departure Location</th>
				<th>Arrival Location</th>
				<th>Fare</th>
				<th>Flight Class</th>
				<th>Flight Valid Till</th>
				<th>Flight Duration</th>
				<th>Flight Time</th>
				<th>Seat Availability</th>
			
		</tr>
		</div>
		<%-- <tr>
					<td colspan="9"><c:if test="${foundFlights == false}">
							<span> <%=Constants.NO_FLIGHTS%></span>
						</c:if></td>
				</tr> --%>

		<c:forEach var="flight" items="${totalMatchedFlights}">
			<tr>
				<td>${flight.number}</td>
				<td>${flight.departureLocation}</td>
				<td>${flight.arrivalLocation}</td>
				<td>${flight.fare}</td>
				<td>${flight.flightClass}</td>
				<td>${flight.validTill}</td>
				<td>${flight.duration}</td>
				<td>${flight.time}</td>
				<td>${flight.seatAvailability}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>