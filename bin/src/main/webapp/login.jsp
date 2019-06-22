<%--
  Created by IntelliJ IDEA.
  User: Yaroslav
  Date: 6/19/2019
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="login" method="post" style="display:flex; flex-direction: column;align-items: center">
    <label for="login">Login: </label>
    <input type="text" name="login" id="login">
    <br>
    <label for="password">Password: </label>
    <input type="password" name="pass" id="password">
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
