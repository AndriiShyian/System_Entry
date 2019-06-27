<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/css/bootstrap.css">
<style>
   <%@include file='css/styleReg.css' %>
</style>
</head>
<body>
<center>
<h1>Registration</h1></center>
<form action="registration" name="form" method="POST">
       <div class="container">
        <div class="row">
            <div class="col-md-12 text center">
                <div class="form">
                    <div class="form-group">
                            <input class="form-control" type="text" name="login" id="login" placeholder = "Login">
                            <input class="form-control" type="password" name="password" id="password" placeholder="Password">
                         <input class="form-control" type="password" name="repeatedPassword" id="password" placeholder="Repeat password">
                          </div>
                    <input type="submit" id="submit" class="btn btn-primary" name="entrance" value="Register me">
                </div>
            </div>
        </div>
      </div>
</form>
</body>
</html>