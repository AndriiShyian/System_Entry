<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file ='css/Apply.css'%>
</style>
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
</head>
<body>
	<%
		String web = "";
		String reg = (String) request.getAttribute("webform");
		if (reg != null) {
			web = reg;
		}
		String gotId = (String) request.getAttribute("login_system_id");
		out.print(gotId);
		out.print(web);
	%>
	<nav class="top-menu"> <a class="navbar-logo" href=""><img
		src="photos/1.png" id="i2"></a>
	<ul class="menu-main">
		<li><a href="Faculties.jsp">Faculties</a></li>
		<li><a href="About.jsp">About</a></li>
		<li><a href="News.jsp">Last news</a></li>
		<li><a href="ContactUs.jsp">Contact us</a></li>
		<li><a href="">My cabinet</a></li>
		<li><a href="">Log out</a></li>
	</ul>
	</nav>
	<center>
		<h1>Applying form</h1>
		<form action="insertingWeb" name="form" method="POST">
			<input type="hidden" name="insertingWebStudent" value=<%=web%> />
			<input type="hidden" name="gotId" value=<%=gotId%> />
			<div class="container">
				<div class="row">
					<div class="col-md-12 text center">
						<div class="form">
							<div class="form-group">
								<div class="centring">
									<table cellpadding="10">
										<tr>
											<td class="tdname">Name</td>
											<td><input class="form-control" type="text" name="name"
												id="name"></td>
										</tr>
										<tr>
											<td class="tdname">Surname</td>
											<td><input class="form-control" type="text"
												name="surname" id="surname"></td>
										</tr>
										<tr>
											<td class="tdname">Date</td>
											<td><input class="form-control" type="text" name="date"
												id="date"></td>
										</tr>
										<tr>
											<td class="tdname">Math</td>
											<td><input class="form-control" type="text" name="math"
												id="math"></td>
										</tr>
										<tr>
											<td class="tdname">Language1</td>
											<td><input class="form-control" type="text"
												name="language1" id="language1"></td>
										</tr>
										<tr>
											<td class="tdname">Language2</td>
											<td><input class="form-control" type="text"
												name="language2" id="language2"></td>
										</tr>
										<tr>
											<td class="tdname">Cerficate</td>
											<td><input class="form-control" type="text"
												name="certificate" id="certificate"></td>
										</tr>
									</table>
								</div>
								<input type="submit" id="submit2" class="btn2 btn-primary"
									name="entrance" value="Apply">
							</div>

						</div>
					</div>
				</div>
			</div>
		</form>

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
	</center>
</body>
</html>