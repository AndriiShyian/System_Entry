<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softserve.ita.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
<%@include file='css/AdminPage.css'%>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	User user = (User) request.getAttribute("user");
%>
<body>
<form action="updating" method="POST" name="form" onsubmit="return validate()">
<center>
	<table border='1'>
		<tr>
			<td>Id</td>
			<td><%=user.getId()%></td>
		</tr>
		<tr>
			<td>Login</td>
			<td><input type="text" name="login" value=<%=user.getLogin()%>></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password"
				value=<%=user.getPassword()%>></td>
		</tr>
		<tr>
			<td>Type of user</td>
			<td><input type="text" name="typeofuser"
				value=<%=user.getTypeOfUser()%>></td>
		</tr>
	</table>
	<input type="submit" id="edit" value="Edit">
	<input type="hidden" name="userId" value="<%=user.getId()%>">
</center>
</form>
<script type="text/javascript">
    <%@include file='scripts/scriptEdit.js'%>
</script>
</body>
</html>