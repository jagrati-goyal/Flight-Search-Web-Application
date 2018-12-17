<%@page import="com.nagarro.flightsearch.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
.bg {
	background-image:
		url("http://www.yunlinplay.tw/gimg/f/68/686820_one-color-wallpaper.jpg");
}

.tablebg {
	background-image:
		url("https://www.xmple.com/wallpaper/plain-green-solid-color-one-colour-single-1920x1080-c-c2dec8-f-24.svg");
}

table, th, td {
	margin-left: 100px;
	border: 1px solid black;
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
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<c:if test="${user.name == null}">
		<c:redirect url="/" />
	</c:if>
	<div class="bg container">
		<form class="btn pull-right" action="logout">
		<h4>User : ${user.name} &nbsp;
			<button
				onclick=" if(!confirm('Do you really want to logout?'))event.preventDefault();">
				Logout</button></h4>
		</form>
		<br/>
		<br />
		<br/>
		<div class="row">
			<h1 style="text-decoration: underline;" align="center">Welcome
				to Flight Search Application</h1>
			<br />
			<div align="center">
				<form:form action="searchFlight" method="post"
					modelAttribute="flightSearchParameters">
					<div class="form-group">
						<spring:message code="lbl.departureLocation" />
						<form:input path="departureLocation" />
						<small> &nbsp;(in 3 letter code)</small> <br />
						<form:errors path="departureLocation" cssClass="error" />
					</div>
					<div class="form-group">
						<spring:message code="lbl.arrivalLocation" />
						<form:input path="arrivalLocation" />
						<small> &nbsp; (in 3 letter code)</small> <br />
						<form:errors path="arrivalLocation" cssClass="error" />
					</div>
					<div class="form-group">
						<spring:message code="lbl.date" />
						<form:input path="date" id="datepicker" />
						<br />
						<form:errors path="date" cssClass="error" />
					</div>
					<div class="form-group">
						<spring:message code="lbl.flightClass" />
						<form:select path="flightClass">
							<form:option label="Select Flight Class" value="" />
							<form:option label="Economic" value="E" />
							<form:option label="Business" value="B" />
						</form:select>
						<br />
						<form:errors path="flightClass" cssClass="error" />
					</div>
					<div class="form-group">
						<spring:message code="lbl.outputPreference" />
						<form:select path="outputPreference">
							<form:option label="Select Sort by" value="" />
							<form:option label="By Fare" value="F" />
							<form:option label="By Fare & Duration" value="FD" />
						</form:select>
						<br />
						<form:errors path="outputPreference" cssClass="error" />
					</div>
					<input type="submit" value="Search Flights" />
				</form:form>

			</div>
		</div>
	</div>
	<br />

	<div class="col-md-11">
		<table class="table tablebg table-bordered">
			<thead>
				<tr class="active">
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
			</thead>
			<tr>
				<c:if test="${totalMatchedFlights.size() == 0}">
					<td colspan="9"><span style="font-weight: bold;"> <%=Constants.NO_FLIGHTS%></span>
					</td>
				</c:if>
			</tr>
			<tbody>
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
	</div>
</body>
</html>