<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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

    button {
      cursor: pointer;
      border-radius: 20px;
      border: 1px solid var(--main-color);
      background: var(--main-color);
      color: #fff;
      font-size: 12px;
      font-weight: bold;
      padding: 12px 45px;
      letter-spacing: 1px;
      text-transform: uppercase;
      transition: transform 80ms ease-out;
    }

    button:hover {
      background: var(--secondary-color);
    }

    button:active {
      transform: scale(0.95);
    }

    button:focus {
      outline: none;
    }

    button.ghost {
      background-color: transparent;
      border-color: #fff;
    }

    button.ghost:hover {
      background: #fff;
      color: var(--secondary-color);
    }

    form {
      margin: 0;
      font-family: "Nunito", sans-serif;
      background-color: #fff;
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      padding: 0 50px 20px 30px;
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
      position: relative;
      overflow: hidden;
      height: 500px;
      width: 480px;
      max-width: 100%;
      padding: 20px 10px;
    }

    .form-container {
      position: absolute;
      top: 0;
      width: 100%;
      transition: all 0.6s ease-in-out;
    }
  </style>

  <body>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
        <form method = "post" action = "saveUser">
          <h1>Sign Up</h1>
          <input type="text" name = "userID" placeholder="User ID: STUDENTID / LECTID" />
          <input type="text" name = "userName" placeholder="Name" />
          <input type="email" name = "userEmail" placeholder="Email" />
          <input type="password" name = "userPassword" placeholder="Password" />
          <select name="userCategory">
            <option disabled selected>Choose User Category</option>
            <option value="Lecturer">Lecturer</option>
            <option value="Student">Student</option>
          </select>
          <input type = "submit" value = "Sign Up"/>
        </form>
      </div>
    </div>
  </body>
</html>

    