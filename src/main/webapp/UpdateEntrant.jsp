<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.softserve.ita.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file='css/AdminPage.css'%>
</style>
</head>
<body>
<%
	User user = (User) request.getAttribute("user");
%>
<body>
<form action="updatingentrant" method="POST" name="form" onsubmit="return validate()">
<center>
	<table border='1'>
		<tr>
			<td>Id</td>
			<td><%=user.getId()%></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value=<%=user.getName()%>></td>
		</tr>
		<tr>
			<td>Surname</td>
			<td><input type="text" name="surname"
				value=<%=user.getSurname()%>></td>
		</tr>
		<tr>
			<td>Date</td>
			<td><input type="text" name="date"
				value=<%=user.getDate()%>></td>
		</tr>
		<tr>
			<td>Login system id</td>
			<td><%=user.getIdOfUser()%></td>
		</tr>
		<tr>
			<td>Points for entry id</td>
			<td><%=user.getIdOfPoints()%>
		</tr>
		
	</table>
	<input type="hidden" name="userId" value="<%=user.getId()%>">
	<input type="submit" id="edit" value="Edit">
</center>
</form>
<script type="text/javascript">
    <%@include file='scripts/scriptEditEntrant.js'%>
</script>
</body>
</body>
</html>