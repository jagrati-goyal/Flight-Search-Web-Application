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
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding: 10px;
}

.main-div {
	background: white none repeat scroll 0 0;
	border-radius: 2px;
	margin: 10px auto 30px;
	max-width: 38%;
	padding: 50px 70px 70px 71px;
}

.login-form  .btn.btn-primary {
	background: #f0ad4e none repeat scroll 0 0;
	border-color: #f0ad4e;
	color: #ffffff;
	font-size: 14px;
	width: 100%;
	height: 50px;
	line-height: 50px;
	padding: 0;
}

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body id="LoginForm">
	<h1 style="text-decoration: underline;" align="center" >Login</h1>
	<br />
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<form:form action="login" method="post" modelAttribute="user">
						<div class="form-group">
							<spring:message code="lbl.username" />
							:
							<form:input path="name" />
							<br />
							<form:errors path="name" cssClass="error" />
							<br />
						</div>
						<div class="form-group">
							<spring:message code="lbl.password" />
							:
							<form:password path="password" />
							<br />
							<form:errors path="password" cssClass="error" />
							<br />
						</div>
						<div class="form-group">
							<input type="submit" value="Login" class="btn btn-primary " /> <br />
						</div>
						<c:if test="${invalidUser==true}">
							<span class="error">Please provide valid Credentials..!!</span>
						</c:if>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>