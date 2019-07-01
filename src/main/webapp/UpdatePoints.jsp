<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.softserve.ita.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	User user = (User) request.getAttribute("user");
%>
<body>
<form action="updatingpoints" method="POST" name="form" onsubmit="return validate()">
<center>
	<table border='1'>
		<tr>
			<td>Id</td>
			<td><%=user.getId()%></td>
		</tr>
		<tr>
			<td>Points for subject 1</td>
			<td><input type="text" name="subject1" value=<%=user.getSubject1() %>></td>
		</tr>
		<tr>
			<td>Points for subject 2</td>
			<td><input type="text" name="subject2"
				value=<%= user.getSubject2() %>></td>
		</tr>
		<tr>
			<td>Points for subject 3</td>
			<td><input type="text" name="subject3"
				value=<%=user.getSubject3()%>></td>
		</tr>
		<tr>
			<td>Certificate</td>
			<td><input type="text" name="certificate"
				value=<%=user.getCertificate()%>></td>
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
</html>