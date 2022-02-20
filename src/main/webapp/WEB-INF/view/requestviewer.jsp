<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Repo-X</title>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

  <!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="header.jsp" %>
</div>
<input type = "hidden" id = "active" data-active = "reqviewer"/>

<body>
	<div id="bodycontent">
		<h2>REQUESTS LIST</h2>
		<table>
			<thead>
				<tr>
					<th scope="col">Software Name</th>
					<th scope="col">Software Version</th>
					<th scope="col">Request Date</th>
					<th scope="col">Request Status</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listrequest}" var="item">
					<tr>
						<td data-label="Software Name">${item.reqswName}</td>
						<td data-label="Software Version">${item.reqswVersion}</td>
						<td data-label="Request Date">${item.reqDate}</td>
						<td data-label="Request Status">${item.reqStatus}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>