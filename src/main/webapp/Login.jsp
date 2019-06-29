<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/css/bootstrap.css">
	<style>
   <%@include file='css/styleReg.css' %>
</style>
</head>
<body>
	<center>
		<h1>Login</h1>
	</center>
	<form action="login" name="form" method="POST" onsubmit="return validate()">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text center">
					<div class="form">
						<div class="form-group">
							<input class="form-control" type="text" name="login" id="login"
								placeholder="login">
							<input class="form-control" type="password" name="password"
							 id="password" placeholder="password">
							<a href="Registration.jsp" id="i1">registration</a>
						</div>
						<input type="submit" id="submit" class="btn btn-primary"
							name="entrance" value="Login">
					</div>
				</div>
			</div>
		</div>
	</form>
<script type="text/javascript">
    <%@include file='scripts/scripts.js'%>
</script>
</body>
</html>