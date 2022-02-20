<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script>
	function rejectalert(swID) {
		if (confirm("Are you sure you want to delete this book?")) {
			location.href = "rejectsw/" + swID;
		}
	}
</script>

<!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="adminheader.jsp" %>
</div>

<input type = "hidden" id = "active" data-active = "adminRequestList"/>

<body>
	<div id="bodycontent">
		<h2 align="center">REQUEST LIST</h2>
		<br>
		<table width="100%" cellpadding="10">
			<tr>
				<th>Software Name</th>
				<th>Software Version</th>
				<th>Software Date</th>
				<th>Status</th>
				<th>User Request</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listrequest}" var="item" varStatus="status">
				<tr align="center">
					<td>${item.reqswName}</td>
					<td>${item.reqswVersion}</td>
					<td>${item.reqDate}</td>
					<td>${item.reqStatus}</td>
					<td>${listuser[status.index].userName}</td>

					<td><a
						href="<%=request.getContextPath()%>/sofwareregister/${item.reqID}">
							<button>Accept</button>
					</a>
						<button class="btn" id="${item.reqID}"
							onclick="rejectalert(this.id)">Reject</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>