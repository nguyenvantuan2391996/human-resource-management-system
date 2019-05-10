<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
	<title>Dashboard Admin</title>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/dashboard.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle navbar-toggle-sidebar collapsed">
					MENU
				</button>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="dashboard_admin">
					Administrator
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      

				<ul class="nav navbar-nav navbar-right">	
					<li><a href="#">Facebook</a></li>
					<li><a href="#">Youtube</a></li>
					<li><a href="#">Google+</a></li>
					<li class="dropdown ">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Account
							<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-header">SETTINGS</li>
								<li class=""><a href="#"><i class="glyphicon glyphicon-user"></i> Profile </a></li>
								<li class=""><a href="#"><i class="glyphicon glyphicon-comment"></i> Message </a></li>
								<li class=""><a href="#"><i class="glyphicon glyphicon-plane"></i> Activity Log</a> </li>
								<li class="divider"></li>
								<li><a href="logout"><i class="glyphicon glyphicon-log-out"></i> Logout</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>  	<div class="container-fluid main-container">
			<div class="col-md-2 sidebar">
				<div class="row">
					<!-- uncomment code for absolute positioning tweek see top comment in css -->
					<div class="absolute-wrapper"> </div>
					<!-- Menu -->
					<div class="side-menu">
						<nav class="navbar navbar-default" role="navigation">
							<!-- Main Menu -->
							<div class="side-menu-container">
								<ul class="nav navbar-nav">
									<li class="active"><a href="dashboard_admin"><span class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
									<li><a href="phongban"><span class="glyphicon glyphicon-home"></span> Quản lý phòng ban </a></li>
									
									<!-- Dropdown-->
									<li class="panel panel-default" id="dropdown">
										<a data-toggle="collapse" href="#dropdown-lvl1">
											<span class="glyphicon glyphicon-user"></span> Quản lý nhân sự <span class="caret"></span>
										</a>

										<!-- Dropdown level 1 -->
										<div id="dropdown-lvl1" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="nav navbar-nav">
													<li><a href="qltruongphong">Quản lý trưởng phòng</a></li>
													<li><a href="qlnhanvien">Quản lý nhân viên</a></li>
													<li><a href="qlungvien">Quản lý ứng viên</a></li>
												</ul>
											</div>
										</div>
									</li>
									
									<li><a href="qltienluong"><span class="glyphicon glyphicon-usd"></span> Quản lý tiền lương </a></li>
								</ul>
							</div><!-- /.navbar-collapse -->
						</nav>

					</div>
				</div>  		</div>
				<div class="col-md-10 content">
					<div class="panel panel-default">
						<div class="panel-heading">
							Dashboard Admin
						</div>
						<div class="panel-body">
							<b><p align="center">Người quản lý có một tài khoản riêng để truy cập vào trang quản trị hệ thống và có các chức năng sau : </p></b>
							<p><b>- Quản lý phòng ban </b>: Tác nhân có thể thêm, sửa, xóa các phòng ban hiện đang hoạt động tại công ty.</p>
							<p><b>- Quản lý nhân sự</b> : Tác nhân có quyền tác động tới thông tin của nhân sự hiện có trong công ty.</p>
							<p><b>- Quản lý tiền lương</b> : Người quản lý có thể tính lương tháng cho từng nhân viên trong công ty và gửi kết quả phiếu lương cho từng nhân viên. Khi cần tổng kết, thống kê thu chi người quản lý có thể xuất ra báo cáo. Khi có sự thay đổi về thu nhập của nhân viên thì tác nhân có thể chỉnh sửa lương trợ cấp của nhân viên đó.</p>
							<p><b>- Đăng xuất</b> : Khi muốn thoát khỏi hệ thống người dùng có thể chọn chức năng đăng xuất để thực hiện mong muốn. Hoặc việc không hoạt động trên hệ thống trong phiên đăng nhập một khoảng thời gian, tài khoản cũng bị đăng xuất khỏi hệ thống.</p>

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