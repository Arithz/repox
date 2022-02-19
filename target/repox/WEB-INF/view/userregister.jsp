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
   	//document.addEventListener("change", categoryselect);

    function categoryselect() {
      const category = document.getElementById("userCategory").value;
      if (category === "Lecturer") {
        document.getElementById("lectnum").style.display = "block";
        document.getElementById("coursecode").style.display = "none";
      } else {
        document.getElementById("coursecode").style.display = "block";
        document.getElementById("lectnum").style.display = "none";
      }
    }
  </script>

  <body>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
        <form method="post" action="saveUser">
          <h1>Sign Up</h1>
          <input type="text" name="userID" placeholder="User ID: STUDENTID / LECTID" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" required/>
          <input type="text" name="userName" placeholder="Name" required/>
          <input type="email" name="userEmail" placeholder="Email" required/>
          <input type="password" name="userPassword" placeholder="Password" required/>
          <select id="userCategory" onchange = "categoryselect()" name="userCategory" required>
            <option disabled selected>Choose User Category</option>
            <option value="Lecturer">Lecturer</option>
            <option value="Student">Student</option>
          </select>

          <input type="text" id="lectnum" name="lecturernum" placeholder="Lecturer Number" />
          <input type="text" id="coursecode" name="coursecode" placeholder="Course Code" />
          <input id="btnsubmit" type="submit" value="Sign Up" />
        </form>
      </div>
    </div>
  </body>
</html>
