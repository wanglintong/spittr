<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>page</title>
</head>

<body style="text-align: center;">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="footer" style="position:absolute;bottom:0;padding: 30px;left:42%">
		<tiles:insertAttribute name="footer" />
	</div>
</body>

</html>