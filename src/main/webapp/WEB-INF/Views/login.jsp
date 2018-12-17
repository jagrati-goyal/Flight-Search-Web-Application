<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search Application</title>
<style type="text/css">
body#LoginForm {
	background-image:
		url("http://www.yunlinplay.tw/gimg/f/68/686820_one-color-wallpaper.jpg");
}

.error {
	color: red;
	font-weight: 35px;
}
</style>
</head>
<body id="LoginForm">
	<div class="container" style="margin-top: 30px;">
		<h2 align="center">Welcome to Flight Search Application</h2>
		<br />
		<div class="card"
			style="width: 400px; height: 250px; margin: 0 auto; margin-bottom: 10px;">
			<div class="bg-info card-title">
				<h1 align="center">Login</h1>
			</div>
			<div class="bg-light card-body text-center">
				<br />
				<form:form action="login" method="post" modelAttribute="user">
					<spring:message code="lbl.username" />
					<form:input path="name" />
					<br />
					<form:errors path="name" cssClass="error" />
					<br />
					<spring:message code="lbl.password" />
					<form:password path="password" />
					<br />
					<form:errors path="password" cssClass="error" />
					<br />
					<input type="submit" value="Login" class="btn btn-info " />
					<br />
					<c:if test="${invalidUser==true}">
						<span class="error">Please provide valid Credentials..!!</span>
					</c:if>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>