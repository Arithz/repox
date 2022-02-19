<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/WEB-INF/css/admin.css"%></style>
</head>

<script>
	function rejectalert(swID) {
		if (confirm("Are you sure you want to delete this book?")) {
			location.href = "rejectsw/" + swID;
		}
	}
</script>

<body>
<h1>Request List</h1>
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
		<c:forEach items="${listrequest}" var="item" varStatus = "status">
			<tr align="center">
				<td>${item.reqswName}</td>
				<td>${item.reqswVersion}</td>
				<td>${item.reqDate}</td>
				<td>${item.reqStatus}</td>
				<td>${listuser[status.index].userName}</td>
				
				<td><a href="<%=request.getContextPath()%>/sofwareregister/${item.reqID}">
						<button>Accept</button>
					</a>
					<button class="btn" id="${item.reqID}" onclick="rejectalert(this.id)">
						Reject
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>