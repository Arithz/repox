<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style><%@include file="/WEB-INF/css/main.css"%></style>
</head>

<style>
	h2{
		font-family: bahnschrift !important;
	}
	
	/* Add a black background color to the top navigation */
	.topnav {
	  background-color: #333;
	  overflow: hidden;
	}
	
	/* Style the links inside the navigation bar */
	.topnav a {
	  float: left;
	  color: #f2f2f2;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	  font-size: 17px;
	  color: white;
	  font-family: bahnschrift !important;
	}
	
	.topnav p {
	  float: right;
	  color: #f2f2f2;
	  text-align: center;
	  margin-right: 20px;
	  text-decoration: none;
	  font-size: 17px;
	  color: white;
	  font-family: bahnschrift !important;
	}
	
	/* Change the color of links on hover */
	.topnav a:hover {
	  background-color: #ddd;
	  color: black;
	}
	
	/* Add a color to the active/current link */
	.topnav a.active {
	  background-color: #04AA6D;
	  color: white;
	 }
</style>

<body>
	<div class="topnav">
	  <a href="requestsoftware">Request Software</a>
	  <a href="requestviewer">View Request</a>
	  <a href="feedback">Feedback</a>
	  <a href="index" style="color: blue;">Logout</a>
	  <p>REPO-X</p>
	</div>
	<h2>SOFTWARE LIST</h2>
	<table>
		<thead>
			<tr>
				<th scope="col">Software Name</th>
				<th scope="col">Software Version</th>
				<th scope="col">Description</th>
				<th scope="col">Category</th>
				<th scope="col">Download Link</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${softwares}" var="item" varStatus="status">
				<tr>
					<td data-label="Software Name">${item.swName}</td>
					<td data-label="Software Version">${item.swVersion}</td>
					<td data-label="Description">${item.swDescription}</td>
					<td data-label="Category">${item.categoryID}</td>
					<td data-label="Download Link">
					<!--  
						<a href="data:application/image;base64,${files[status.index]}" download = "${item.swName}.png">Download link</a>
						<a href="<%=request.getContextPath()%>/download/${item.swID}">Go</a>
					-->
					<a href="data:application/zip;base64,${files[status.index]}">Download link</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>