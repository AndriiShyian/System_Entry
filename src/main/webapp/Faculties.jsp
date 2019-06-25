<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file='css/Faculties.css'%>
</style>
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
</head>
<body>
<%
		Integer reg = (Integer) request.getAttribute("getIdOfUser");
		String login_system_id = String.valueOf(reg); 
		out.print(login_system_id);
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
		<h1>Site of the entrance to university</h1>
	</center>
	<div class="container">
		<div class="row">
            <form action="web" name="form" method="POST"> 
            <input type="hidden" name="webform" value="web">
            <input type="hidden" name="login_system_id" value=<%=login_system_id %>>
			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/web-development-photo.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Web Development</a>
						</h3>
						<p>Choosing our institute you will study such technologies as:
							html, css, javascript basic, javascript advanced, java,
							bootstrap,react,php. You will take in competitions, the best
							participants will be invited to work in top companies such as
							Google, Microsoft, SoftServe.</p>
					</div>
					<div class="read">
							 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>
			</form>

			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/math-institute-photo.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Math institute</a>
						</h3>
						<p>Math institute program based on studing as mathematic as
							programming languages. Here you will be surrounded by the best
							professors in our country. Also you will have chance to gain
							experience in outer top universities taking part in our
							student-changing program.</p>
					</div>
					<div class="read">
						 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/economy-faculty-photo.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Economy institute</a>
						</h3>
						<p>We are leading institute that offer our students to be
							involved into different economy programs. Our students has 24/7
							access to our auditories. So they can study easy and do it any
							time they want. In the third year of studying our students do
							research work on economic topics.</p>
					</div>
					<div class="read">
						 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>

		</div>
		<!-- ./row -->
	</div>
	<div class="container">
		<div class="row">

			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/chemistry-faculty-logo.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Chemistry institute</a>
						</h3>
						<p>Chemistry is the most important science in the country
							progress so it is good-paid profession. We supporting our
							students during they study here. As it is very responsible
							profession our students studying 6 years. We guarantee that
							studing with us is very intresting</p>
					</div>
					<div class="read">
						 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/law-institute-logo.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Law institute</a>
						</h3>
						<p>We represents more than 19,000 lawyers and people working
							in the law in our country and overseas. Our members offer their
							commitment, diversity and expertise to help shape the laws of
							country and to ensure justice for all. Join us and you will
							become an excellent layer</p>
					</div>
					<div class="read">
						 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/foreign-language-institute.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Foreign language institute</a>
						</h3>
						<p>Students are taught in four departments (English, German,
							French and Chinese). Faculty programme provides study of two
							foreign languages (English, German, French, or Spanish, Chinese -
							at student's option), and a third foreign language (German,
							French, Spanish, Italian, Greek, Chinese)-optional.</p>
					</div>
					<div class="read">
						 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>

		</div>
		<!-- ./row -->
	</div>




	<div class="container">
		<div class="row">

			<div class="col-md-4 col-sm-6">
				<div class="serviceBox">
					<div class="service-icon">
						<i><img src="photos/computer-science-logo.png" id="i1"></i>
					</div>
					<div class="service-content">
						<h3>
							<a href="#">Computer science institute</a>
						</h3>
						<p>As a member of the Computer Science Institute, you decide
							what you want to study and for how long. Courses range from basic
							content knowledge for aspiring and novice teachers to long-term
							planning and assessment development for those with experience.
							Choose from a 4-day summer intensive, a 5-week extended
							professional development, or a 4-month sustained professional
							development based on your needs and availability.</p>
					</div>
					<div class="read">
						 <input type="submit" id="submit" class="btn btn-default" name="apply" value="Apply">
					</div>
				</div>
			</div>
		</div>
		<!-- ./row -->
	</div>

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