<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard Candidate</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/dashboard.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button"
				class="navbar-toggle navbar-toggle-sidebar collapsed">MENU
			</button>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="dashboard_ungvien.html"> Candidate
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" method="GET" role="search">
				<div class="form-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Facebook</a></li>
				<li><a href="#">Youtube</a></li>
				<li><a href="#">Google+</a></li>
				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">
						Account <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">SETTINGS</li>
						<li class=""><a href="#"><i
								class="glyphicon glyphicon-user"></i> Profile </a></li>
						<li class=""><a href="#"><i
								class="glyphicon glyphicon-comment"></i> Message </a></li>
						<li class=""><a href="#"><i
								class="glyphicon glyphicon-plane"></i> Activity Log</a></li>
						<li class="divider"></li>
						<li><a href="logout"><i
								class="glyphicon glyphicon-log-out"></i> Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<div class="row">
				<!-- uncomment code for absolute positioning tweek see top comment in css -->
				<div class="absolute-wrapper"></div>
				<!-- Menu -->
				<div class="side-menu">
					<nav class="navbar navbar-default" role="navigation"> <!-- Main Menu -->
					<div class="side-menu-container">
						<ul class="nav navbar-nav">
							<li><a href="dashboard_ungvien"><span
									class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
							<li class="active"><a href="thitest"><span
									class="glyphicon glyphicon-home"></span> Thi test </a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse --> </nav>

				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">
					<marquee>Chào mừng bạn đã tham gia kì thi tuyển dụng nhân
						sự của chúng tôi. Chúc bạn làm bài thi với kết quả tốt nhất</marquee>
				</div>
				<div class="panel-body">

					<form action="thitest" method="post">
						<c:if test="${empty notice}">
							<h4>Chủ đề : ${chude }</h4>
						</c:if>
						
						<h4 align="center" style="color: red">${notice }</h4>
						<br>
						<c:forEach items="${arrcauhoi }" var="arrcauhoi">
							<ul class="answers">

								<p>
									<b>Câu ${arrcauhoi.macauhoi} : ${arrcauhoi.cauhoi}</b>
								</p>
								<br>
								<label class="radio-inline"> <input type="radio"
									name="${arrcauhoi.macauhoi}" value="A">${arrcauhoi.a}
								</label>
								<label class="radio-inline"> <input type="radio"
									name="${arrcauhoi.macauhoi}" value="B">${arrcauhoi.b}
								</label>
								<label class="radio-inline"> <input type="radio"
									name="${arrcauhoi.macauhoi}" value="C">${arrcauhoi.c}
								</label>
								<label class="radio-inline"> <input type="radio"
									name="${arrcauhoi.macauhoi}" value="D">${arrcauhoi.d}
								</label>
							</ul>
							<br>
						</c:forEach>

						<c:if test="${empty notice}">
							<!-- Button next -->
							<ul class="pagination pull-left">
								<li><input type="submit"
									<c:if test="${page == 5 }" >
									value="<c:out value="Submit"></c:out>"
								</c:if>
									<c:if test="${page < 5 }" >
									value="<c:out value="Next"></c:out>"
								</c:if>
									class="btn btn-primary"></li>
							</ul>
						</c:if>
					</form>


				</div>
			</div>
		</div>
		<footer class="pull-left footer">
		<p class="col-md-12">
		<hr class="divider">
		Copyright &COPY; 2019 by Nguyen Van Tuan</a>
		</p>
		</footer>
	</div>
	<!-- file js -->
	<script src="bootstrap/js/dashboard.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/jquery-1.11.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>