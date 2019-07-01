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
				<td>Points for 1 subject</td>
				<td>Points for 2 subject</td>
				<td>Points for 3 subject</td>
				<td>Certificate</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getSubject1()%></td>
				<td><%=list.get(i).getSubject2()%></td>
				<td><%=list.get(i).getSubject3()%></td>
				<td><%=list.get(i).getCertificate() %></td>
				<form action="helpedtoupdatepoints?uid=<%=list.get(i).getId() %>" method="post" name="form">
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