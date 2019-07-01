<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file='css/AdminPage.css'%>
</style>
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
</head>
<%Integer id = (Integer)request.getAttribute("id");%>
<body>
	<nav class="top-menu"> <a class="navbar-logo" href=""><img
		src="photos/1.png" id="i2"></a>
	<ul class="menu-main">
		<li><a href="AdminPage.jsp">Admin page</a></li>
		<li><a href="Login.jsp">Log out</a></li>
	</ul>
	</nav>
	<center>
		<h1>Data of that user is using in other tables. Do you want to delete this user from system?</h1>
		<form action="DeletingController" name="form" method="post">
	<input type="submit" id="input" value="Delete user from system">
	<input type="hidden" name="id" value="<%=id%>">
	</form>
</center>
	<hr class="cleanit">

	<div id="footer">
		<div id="footer_in">

			<p>
				<a href="">Willanova university</a> &mdash; we are always open to
				you
			</p>
			<span>Author: Andrii</span>


		</div>
	</div>
</body>
</html>