<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Repo-X</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
  </head>

<body style="background-color: rgb(238, 238, 238);">
	<div id="bodycontent">
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form method="post" action="loginAdmin">
					<h1>Sign In</h1>
					<input type="text" name="adminID" placeholder="Admin ID"
					oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" required /> 
					
					<input type="password" name="adminPassword" placeholder="Password" required /> 
					<input id="btnsubmit" type="submit" value="Sign In" />
					<a href="index">Go Back</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
