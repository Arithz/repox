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

<script>
	function deletealert(swID) {
		if (confirm("Are you sure you want to delete this book?")) {
			location.href = "checksoftware/" + swID;
		}
	}
</script>

<!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="adminheader.jsp" %>
</div>

<input type = "hidden" id = "active" data-active = "adminswlist"/>

<body>
<div id = "bodycontent">
	<h2 align = "center">SOFTWARE LIST</h2>
	<c:if test="${not empty alert}">
		${alert}
	</c:if>
	<br>
	<table width="100%" cellpadding="10">
		<tr>
			<th>Software ID</th>
			<th>Software Name</th>
			<th>Software Version</th>
			<th>Software Description</th>
			<th>Category</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${softwares}" var="item" varStatus = "status">
			<tr align="center">
				<td>${item.swID}</td>
				<td>${item.swName}</td>
				<td>${item.swVersion}</td>
				<td>${item.swDescription}</td>
				<td>${categories[status.index].categoryName}</td>
				<td><a href="<%=request.getContextPath()%>/editsw/${item.swID}"><button>Edit</button></a></td>
				<td><button class="btn" id="${item.swID}" onclick="deletealert(this.id)">
						Delete
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<div class = "row" style = "display:flex; gap:10px; margin-top:10px; justify-content:center">
		<a href="adminsoftwareregister"><button style="width: 140px;">Add Software</button></a>
		<a href="adminsoftwareanalysis"><button style="width: 140px;">Software Analysis</button></a>
	</div>

</div>
</body>
</html>