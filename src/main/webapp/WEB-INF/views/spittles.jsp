<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Spittles</title>

</head>

<body>
	<h1>Recent Spittles</h1>
	<c:forEach items="${spittleList }" var="spittle">
		<p>${spittle.message }</p>
	</c:forEach>

</body>

</html>