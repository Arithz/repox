<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Repo-X</title>
	<style><%@include file ="/WEB-INF/css/admin.css"%></style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

<!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="adminheader.jsp" %>
</div>

<body>
<div id = "bodycontent">
	<h2 align = "center">USER DOWNLOAD DETAILS</h2>
	<br>
	<table width="100%" cellpadding="10">
		<tr>
			<th>Software Name</th>
			<th>Software Version</th>
			<th>Username</th>
			<th>User Category</th>
		</tr>
		<c:forEach items="${histories}" var="item" varStatus="status">
			<tr align="center">
				<td>${item[0]}</td>
				<td>${item[1]}</td>
				<td>${item[2]}</td>
				<td>${item[3]}</td>
			</tr>
		</c:forEach>

		</table>

	<br />
	<div class = "row" style = "display:flex; gap:10px; margin-top:10px; justify-content:center">
		<a href="adminswlist"><button style="width: 140px;">Go Back</button></a>
	</div>

</div>
</body>
</html>