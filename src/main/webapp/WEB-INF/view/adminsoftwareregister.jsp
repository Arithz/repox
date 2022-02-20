<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <script>
  $(document).ready(function(){
	  $('#image-file').on('change', function() {
		  console.log('This file size is: ' + this.files[0].size / 1024 + "KiB");
		});
  });
  </script>

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Repo-X</title>
	<style><%@include file ="/WEB-INF/css/main.css"%></style>
	<style><%@include file ="/WEB-INF/css/admin.css"%></style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

  <style>
    #btncat {
      cursor: pointer;
      border-radius: 2px;
      border: 0px;
      background: #474747;
      color: #fff;
      font-size: 12px;
      padding: 7px 15px;
      font-weight: bold;
      text-transform: uppercase;
      transition: transform 80ms ease-out;
      margin-top: 0px;
    }

    #btncat:hover {
      background: #2b2b2b;
    }

    .row {
      display: flex;
      flex-direction: row;
      align-items: center;
      width: 100%;
      gap: 10px;
    }
  </style>
  
  <!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="adminheader.jsp" %>
</div>

  <body style="background-color:rgb(238, 238, 238);">
 	<div id = "bodycontent">
    <div class="container" id="container">
      <div class="form-container sign-up-container">
		<form method="post" action="saveSoftware" enctype="multipart/form-data">
			<h1>Software Register Form</h1>
			<c:if test="${not empty request}">
				<input type="hidden" name="reqID" value = "${request.reqID}" required /> 
				<input type="text" name="swName" placeholder="Software Name" value = "${request.reqswName}" required /> 
				<input type="number" step="0.01" min="0.1" name="swVersion" placeholder="Software Version" value = "${request.reqswVersion}" required />
			</c:if>
			<c:if test="${empty request}">
				<input id = "swName" type="text" name="swName" placeholder="Software Name" required /> 
          		<input id = "swVersion" type="number" step="0.01" min="0.1" name="swVersion" placeholder="Software Version" required />
			</c:if>
			<textarea name="swDescription" rows="4" cols="50"></textarea>
			<div class="row">
				<select name="categoryID" required>
					<option disabled selected>Choose Software Category</option>
					<c:forEach items="${categories}" var="item">
						<option value="${item.categoryID}">${item.categoryName}</option>
					</c:forEach>
				</select> <a id="btncat" href="categoryregister">New Category</a>
			</div>
			<input id = "image-file" type = "file" name = "swFile" required/>
			<input id="btnsubmit" type="submit" value="Add Software" />
		</form>
      </div>
    </div>
    </div>
  </body>
</html>
