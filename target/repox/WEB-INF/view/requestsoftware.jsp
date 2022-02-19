<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    
    <style><%@include file="/WEB-INF/css/main.css"%></style>
  </head>

  <script>
    function getCurrentDate() {
      var date = new Date();
      const currentdate =
        date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2) + "-" + date.getDate();
      document.getElementById("reqDate").value = currentdate;
    }
  </script>

  <body>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
        <form method="post" action="registerNewRequest">
          <h1>Software Request Form</h1>
          <input
            type="text"
            placeholder="Request Software Name"
            name="reqswName"
            onclick="getCurrentDate()"
            required
          />
          <input
            type="number"
            type="number"
            step="0.01"
            min="0.1"
            placeholder="Request Software Version"
            name="reqswVersion"
          />

          <input id="reqDate" type="date" name="reqDate" readonly required />

          <input type="submit" id="btnsubmit" value="Submit" />
        </form>
      </div>
    </div>
          <a href = "softwareviewer">Back</a>
  </body>
</html>
