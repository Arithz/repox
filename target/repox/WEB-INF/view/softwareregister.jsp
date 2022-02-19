<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    
    <style><%@include file="/WEB-INF/css/main.css"%></style>
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

  <body>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
		<form method="post" action="saveSoftware" enctype="multipart/form-data">
			<h1>Software Register Form</h1>
			<input type="text" name="swName" placeholder="Software Name" required /> 
          	<input type="number" step="0.01" min="0.1" name="swVersion" placeholder="Software Version" required />
			<textarea name="swDescription" rows="4" cols="50"></textarea>
			<div class="row">
				<select name="categoryID" required>
					<option disabled selected>Choose Software Category</option>
					<c:forEach items="${categories}" var="item">
						<option value="${item.categoryID}">${item.categoryName}</option>
					</c:forEach>
				</select> <a id="btncat" href="category">New Category</a>
			</div>
			<input type = "file" name = "swFile" accept = ".zip" required/>
			<input id="btnsubmit" type="submit" value="Sign Up" />
		</form>
      </div>
    </div>
  </body>
</html>
