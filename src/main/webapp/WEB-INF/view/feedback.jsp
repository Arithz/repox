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
    body {
      background-color: rgb(238, 238, 238);
    }

    .container {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(500px, 1fr));
    }
    .feedback {
      background-color: white;
      padding: 20px 30px;
      box-shadow: 0 3px 10px rgba(199, 199, 199, 0.2);
      border-radius: 5px;
      text-align: center;
      margin: 10px 20px;
    }

    .header {
      font-size: 20px;
      font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS", sans-serif;
      margin: 10px;
    }

    .createfeedback {
      background-color: white;
      padding: 20px 30px;
      box-shadow: 0 3px 10px rgba(199, 199, 199, 0.2);
      border-radius: 5px;
      text-align: center;
      margin: 10px 20px;
      text-align: center;
    }

    .createfeedback textarea {
      width: 60%;
      min-height: 90%;
      max-height: 150%;
    }

    textarea {
      appearance: none;
      border: none;
      resize: vertical;
      outline: none;
      white-space: normal;
      -moz-text-align-last: center; /* Firefox 12+ */
      text-align-last: center;
    }
  </style>

  <body>
    <div class="createfeedback">
      <form>
        <textarea rows="3">Write your feedback for the system...</textarea>
      </form>
    </div>
    <div class="container">
      <div class="feedback">
        <div class="header">Username: ID2019XXXXXX</div>
        <div>
          <p>wadguiawhdoihawiodaiowhodihawoidawhodihaowid</p>
        </div>
      </div>

      <div class="feedback">
        <div class="header">Username: ID2019XXXXXX</div>
        <div>
          <p>wadguiawhdoihawiodaiowhodihawoidawhodihaowid</p>
        </div>
      </div>

      <div class="feedback">
        <div class="header">Username: ID2019XXXXXX</div>
        <div>
          <p>wadguiawhdoihawiodaiowhodihawoidawhodihaowid</p>
        </div>
      </div>
    </div>
  </body>
</html>