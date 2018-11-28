<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<html>
  <body>
    <div>
      <form action="/AuthorizationServlet" method="POST">
        <br>
        <input type="text" placeholder="Enter your name" name="userName">
        <br/><br/>
        <input type="password" placeholder="Enter password" name="userPassword">
        <br/><br/>
        <input type="submit" value="Submit">
      </form>
    </div>
</body>
</html>
