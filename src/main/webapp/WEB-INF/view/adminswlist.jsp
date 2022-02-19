<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Repo-X</title>
<style><%@include file="/WEB-INF/css/admin.css"%></style>
</head>

<style>
</style>

<script>
	function deletealert(swID) {
		if (confirm("Are you sure you want to delete this book?")) {
			location.href = "checksoftware/" + swID;
		}
	}
</script>
<body>
	<c:if test="${not empty alert}">
		${alert}
	</c:if>
	<h1>Software List</h1>
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
	<a href="#"><button
			style="width: 140px; margin-left: 45%; margin-top: 20px;">Add
			New Book</button></a>
	<a href="#"><button class="btn">Logout</button></a>
</body>
</html>