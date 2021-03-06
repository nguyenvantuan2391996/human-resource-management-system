<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard Manager</title>
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
			<a class="navbar-brand" href="dashboard_truongphong"> Manager </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

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
							<li><a href="dashboard_truongphong"><span
									class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
							<li><a href="qlot"><span
									class="glyphicon glyphicon-time"></span> Quản lý OT </a></li>
							<li><a href="nhanvien"><span
									class="glyphicon glyphicon-user"></span> Quản lý nhân viên </a></li>
							<li><a href="qlnghiphep"><span
									class="glyphicon glyphicon-signal"></span> Quản lý nghỉ phép </a></li>
							<li><a href="qlbaocao"><span
									class="glyphicon glyphicon-list-alt"></span> Quản lý báo cáo </a></li>

							<!-- Dropdown-->
							<li class="panel panel-default" id="dropdown"><a
								data-toggle="collapse" href="#dropdown-lvl1"> <span
									class="glyphicon glyphicon-calendar"></span> Tư vấn tuyển dụng
									<span class="caret"></span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-lvl1">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="danhgiaungvien">Đánh giá ứng viên</a></li>
											<li class="active"><a href="nhaptrongso">Xem tư vấn</a></li>
										</ul>
									</div>
								</div></li>
						</ul>
					</div>
					<!-- /.navbar-collapse --> </nav>

				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Vui lòng nhập trọng số cho từng
					tiêu chí</div>
				<br> <b><p style="color: red" align="center">${msg }</p></b> <br>
				<br>
				<div class="panel-body">
					<div class="container">

						<!--Table Content-->
						<div class="row">

							<div class="col-md-12">
								<div class="table-responsive">

									<table id="mytable" class="table table-bordred table-striped">

										<!--Form lấy trọng số-->
										<form method="post" action="trongso">
											<thead>
												<th></th>
												<th>Hòa Đồng</th>
												<th>Trung Thực</th>
												<th>Quản Trị</th>
												<th>Phân Tích</th>
												<th>Ngoại Ngữ</th>
												<th>Tin Học</th>
												<th>CNTT</th>
												<th>Xử Lý TT</th>
												<th>Giao Tiếp</th>
											</thead>

											<tr>
												<td>Trọng Số</td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="hoadong" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="trungthuc" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="quantri" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="phantich" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="ngoaingu" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="tinhoc" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="cntt" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="xuly" required></td>
												<td><input class="form-control " type="number"
													min="0.01" max="1" step="0.01" name="giaotiep" required></td>
											</tr>
									</table>
									<ul class="pagination pull-right">
										<li><input type="submit" value="Xác nhận" name="xacnhan"
											class="btn btn-primary"></li>
									</ul>
									</form>
								</div>

							</div>
						</div>
					</div>

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
	<script src="bootstrap/js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>