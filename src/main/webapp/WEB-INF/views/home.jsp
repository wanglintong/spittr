<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="${pageContext.request.contextPath }/logo.png" type="image/png" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spittr</title>
</head>
<body>
	<h1>Welcome to Spittr</h1>
	<a href="<c:url value="/spittles" />">Spittles</a> <br/><br/>
	<a href="<c:url value="/spitter/register" />">Register</a> <br/><br/>
	<a href="<c:url value="/spitter/userPage" />">userPage</a> <br/><br/>
	<shiro:hasRole name="admin">
		<a href="<c:url value="/spitter/adminPage" />">adminPage</a> <br/><br/>
	</shiro:hasRole>
	<a href="<c:url value="/logout" />">logout</a> <br/><br/>
</body>
</html>