<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body><%-- 
		<h2>Success page</h2>
		<table>
				<tr>
					<td>Flight Number</td>
					<td>Departure Location</td>
					<td>Arrival Location</td>
					<td>Fare</td>
					<td>Flight Class</td>
					<td>Flight Valid Till</td>
					<td>Flight Duration</td>
					<td>Flight Time</td>
					<td>Seat Availability</td>

				</tr>
				<tr>
					<td colspan="9"><c:if test="${foundFlights == false}">
							<span> <%=Constants.NO_FLIGHTS%></span>
						</c:if></td>
				</tr>
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
		 --%>
	
</body>
</html>