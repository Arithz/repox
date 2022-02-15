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

    #btnsignup {
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

    #btnsignup:hover {
      background: var(--secondary-color);
    }

    #btnsignup:active {
      transform: scale(0.95);
    }

    #btnsignup:focus {
      outline: none;
    }

    #btnsignup.ghost {
      background-color: transparent;
      border-color: #fff;
    }

    #btnsignup.ghost:hover {
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

    input {
      background-color: #eee;
      border: none;
      padding: 12px 15px;
      margin: 8px 0;
      width: 100%;
      font-family: inherit;
    }

    input[type="submit"] {
      width: unset;
    }

    .container {
      margin: auto;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
      position: relative;
      overflow: hidden;
      height: 550px;
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
        <form>
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

          <input type="hidden" name="reqStatus" value="1" />
          <input type="hidden" name="userID" />

          <input type="submit" id="btnsignup" value="Submit" />
        </form>
      </div>
    </div>
  </body>
</html>
