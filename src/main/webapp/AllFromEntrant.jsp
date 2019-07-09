<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.softserve.ita.model.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%ArrayList<User> list = (ArrayList<User>) request.getAttribute("users"); %>
<body>
<center>
	<br>
	<br>
		<table border='1'>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Surname</td>
				<td>Date</td>
				<td>Login system id</td>
				<td>Points for entry id</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getSurname()%></td>
				<td><%=list.get(i).getDate()%></td>
				<td><%=list.get(i).getIdOfUser() %></td>
				<td><%=list.get(i).getIdOfPoints() %></td>
				<form action="helpedtoupdateentrnat?uid=<%=list.get(i).getId() %>" method="post" name="form">
				<td><input type="submit" value="edit"></td>
				</form>
			</tr>
			<%
				}
			%>
		</table>
		</center>
</body>
</html>