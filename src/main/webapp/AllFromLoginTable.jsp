<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.softserve.ita.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
<%@include file='css/styleReg.css'%>
</style>
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
%>
<body>
<center>
	<br>
	<br>
		<table border='1'>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Surname</td>
				<td>Type of User</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getLogin()%></td>
				<td><%=list.get(i).getPassword()%></td>
				<td><%=list.get(i).getTypeOfUser()%></td>
				<form action="helpedtoupdate?uid=<%=list.get(i).getId() %>" method="post" name="form">
				<td><input type="submit" value="edit"></td>
				</form>
				<form action="helpedtodelete?uid=<%=list.get(i).getId() %>" method="post" name="form">
				<td><input type="submit" value="delete"></td>
				</form>
			</tr>
			<%
				}
			%>
		</table>
		</center>
</body>
</html>