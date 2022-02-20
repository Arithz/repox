<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Repo-X</title>
    
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  </head>

  <script>
    function getCurrentDate() {
      var date = new Date();
      const currentdate =
        date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2) + "-" + date.getDate();
      document.getElementById("reqDate").value = currentdate;
    }
  </script>
  
  <!--Navigation bar-->
<div id="nav-placeholder">
	<%@include file="header.jsp" %>
</div>
<input type = "hidden" id = "active" data-active = "reqsw"/>

<body style="background-color: rgb(238, 238, 238);">
	<div id="bodycontent">
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form method="post" action="registerNewRequest">
					<h1>Software Request Form</h1>
					<input type="text" placeholder="Request Software Name"
						name="reqswName" onclick="getCurrentDate()" required />
					<input type="number" type="number" step="0.01" min="0.1"
						placeholder="Request Software Version" name="reqswVersion" />

					<input id="reqDate" type="date" name="reqDate" readonly required />

					<input type="submit" id="btnsubmit" value="Submit" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
