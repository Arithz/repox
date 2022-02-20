<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Repo-X</title>
	<style><%@include file ="/WEB-INF/css/main.css"%></style>
	<style><%@include file ="/WEB-INF/css/admin.css"%></style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  </head>

<!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="adminheader.jsp"%>
</div>

<body style="background-color: rgb(238, 238, 238);">
	<div id="bodycontent">
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form method="post" action="saveCat">
					<h1>Add New Category</h1>
					<input type="text" placeholder="Category Name" name="categoryName" />
					<input id="btnsubmit" type="submit" value="Add" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
