<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>

  <style>
    :root {
      --main-color: #6dd5ed;
      --secondary-color: #2193b0;
      --gradient: linear-gradient(135deg, var(--main-color), var(--secondary-color));
    }

    * {
      box-sizing: border-box;
    }

    .form-container h1 {
      margin-top: 50px;
      margin-bottom: 40px;
    }

    .form-container button {
      margin-top: 20px;
    }

    form {
      margin: 0;
      font-family: "Nunito", sans-serif;
      background-color: #fff;
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      padding: 0 30px 20px 30px;
      height: 100%;
      text-align: center;
    }

    input,
    select {
      background-color: #eee;
      border: none;
      padding: 12px 15px;
      margin: 8px 0;
      width: 100%;
      font-family: inherit;
    }

    .container {
      margin: auto;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
      height: min-content;
      width: 480px;
      max-width: 100%;
      padding: 20px 10px;
    }

    .form-container {
      top: 0;
      width: 100%;
      transition: all 0.6s ease-in-out;
    }

    #btnsubmit {
      background-color: #a3a3a3;
      transition: 0.1s ease-in-out;
      border-radius: 2px;
      cursor:pointer;
    }
    #btnsubmit:hover {
      background-color: #636363;
      color: white;
    }

    #lectnum,
    #coursecode {
      display: none;
    }
  </style>
  
  <body>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
        <form method="post" action="loginAdmin">
          <h1>Sign In</h1>
          <input type="text" name="userID" placeholder="Admin ID" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" required/>
          <input type="password" name="adminPassword" placeholder="Password" required/>
    
          
          <input id="btnsubmit" type="submit" value="Sign In" />
        </form>
      </div>
    </div>
  </body>
</html>
