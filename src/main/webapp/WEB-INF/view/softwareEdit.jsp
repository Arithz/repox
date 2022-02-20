<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Repo-X</title>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<style><%@include file="/WEB-INF/css/header.css"%></style>
<body>
   <div class="topnav">
	<div class="topnav">
	  <a href="adminswlist">Back</a>
	  <p>REPO-X</p>
	</div>
	</div>
	<br><br>
   <div class="container" id="container">
      <div class="form-container sign-up-container">
	<form method="POST" name="update" action="updatesw">
	<h1>Update Software</h1>
		<table>
			<input name="swID" type = "hidden" value="${softwares.swID}"/> 
			<tr>
				<td>Software Name:</td>
				<td><input name="swName" value="${softwares.swName}" type="text" /></td>
			</tr>
			<tr>
				<td>Software Version:</td>
				<td><input name="swVersion" step="0.01" min="0.1" value="${softwares.swVersion}" type="number" /></td>
			</tr>
			<tr>
				<td>Software Description</td>
				<td><textarea name="swDescription" rows="4" cols="50">${softwares.swDescription}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="button" value="Update" type="submit" /></td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>

<style>	
	.container {
		width:600px;
		
	}
	.button{
		text-align: center;
		width: 100px;
		height: 40px;
		border-radius: 8px;
		display: inline;
		border: 0;
		background: #E9190F;
		color: white;
	}
	
	.button:hover{
	    background: #FF5A5F;
	    color: white;
	}
</style>

</html>