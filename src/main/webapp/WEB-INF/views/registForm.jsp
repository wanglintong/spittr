<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
	.error {
		color:red;
	}
</style>
</head>

<body>
	<h1>Register</h1>
	<s:url value="/spitter/register" var="registerUrl"/>
	<sf:form method="POST" commandName="spitter" action="${registerUrl }">
		Last Name: <sf:input path="lastName"/><sf:errors path="lastName" cssClass="error"/> <br/>
		First Name: <sf:input path="firstName"/><sf:errors path="firstName" cssClass="error"/> <br/>
		Username: <sf:input path="username"/><sf:errors path="username" cssClass="error"/> <br/>
		Password: <sf:password path="password"/><sf:errors path="password" cssClass="error"/> <br/>
		<input type="submit" value="Register">
	</sf:form>
</body>

</html>