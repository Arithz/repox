<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
  </head>

  <body>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
        <form method="post" action="saveCat">
          <h1>Add New Category Form</h1>
          <input type="text" placeholder="Category Name" name="categoryName" />
          <input id="btnsubmit" type="submit" value="Add" />
        </form>
      </div>
    </div>
  </body>
</html>
