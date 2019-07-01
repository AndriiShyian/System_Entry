<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.softserve.ita.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<td>Name</td>
				<td>Surname</td>
				<td>zPoints</td>
				<td>Institute</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getSurname()%></td>
				<td><%=list.get(i).getPoints()%></td>
				<td><%=list.get(i).getFaculty()%></td>
			</tr>
			<%
				}
			%>
		</table>
		</center>
</body>
</html>