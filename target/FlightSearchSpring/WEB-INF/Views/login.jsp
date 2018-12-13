<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search Application</title>
<style type="text/css">
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div style="margin-top: 100px" align="center">
		<h2>Login Page</h2>
	 	<form:form action="login" method="post" modelAttribute="user">
			<spring:message code="lbl.username" />:
			<form:input path="name"/><br /> 
			<form:errors path="name" cssClass="error" /><br/>
			<spring:message code="lbl.password" />:
			<form:password path="password"/><br /> 
			<form:errors path="password" cssClass="error" /><br/>
			<input type="submit" value="Login" /> <br />
			<c:if test="${invalidUser==true}">
			<span class="error">"Please provide valid Credentials..!!"</span>
			</c:if>
		</form:form> 
	</div>
</body>
</html>