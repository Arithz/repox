<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Repo-X</title>
	<style><%@include file ="/WEB-INF/css/main.css"%></style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

<!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="adminheader.jsp" %>
</div>

<input type = "hidden" id = "active" data-active = "adminfeedback"/>

<body style="background-color: #E9ECEF;">
	
	<div class="feedback-container">

		<c:forEach items="${listfeedback}" var="item" varStatus="status">
			<div class="feedback">
				<div class="header">Username: ${listusername[status.index]}</div>
				<div>
					<p>${item.feedbackDetails}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>