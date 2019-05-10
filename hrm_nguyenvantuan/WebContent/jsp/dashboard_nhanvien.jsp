<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
	<title>Dashboard Employee</title>
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
				<a class="navbar-brand" href="dashboard_nhanvien.html">
					Employee
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
									<li class="active"><a href="dashboard_nhanvien"><span class="glyphicon glyphicon-dashboard"></span> Dashboard </a></li>
									<li><a href="baocaonv"><span class="glyphicon glyphicon-list-alt"></span> Báo cáo </a></li>
									<li><a href="dangkyot"><span class="glyphicon glyphicon-time"></span> Đăng ký OT </a></li>
									<li><a href="dangkynghiphep"><span class="glyphicon glyphicon-signal"></span> Đăng ký nghỉ phép </a></li>
									<li><a href="xemphieuluong"><span class="glyphicon glyphicon-usd"></span> Xem phiếu lương </a></li>
								</ul>
							</div><!-- /.navbar-collapse -->
						</nav>

					</div>
				</div>  		</div>
				<div class="col-md-10 content">
					<div class="panel panel-default">
						<div class="panel-heading">
							Dashboard
						</div>
						<div class="panel-body">
							<p align="center"><b>Nhân viên được cấp một tài khoản và mật khẩu riêng để truy cập vào trang nhân viên có đầy đủ chức năng của tác nhân như sau :</b></p>
								<p><b>- Báo cáo</b> : Nhân viên phải thực hiện viết báo cáo hằng ngày và gửi báo cáo cho người trưởng phòng quản lý mình để thông báo tiến độ làm việc của mình đối với công việc được giao.</p>
								<p><b>-	Đăng ký OT, nghỉ phép</b> : Tác nhân có thể dùng các chức năng này để xin làm thêm giờ và xin nghỉ phép khi có nhu cầu.</p>
								<p><b>-	Xem chi tiết phiếu lương</b> : Sau khi được người quản lý gửi phiếu lương, tác nhân có thể xem chi tiết phiếu lương của mình tháng này. Nếu có thắc mắc thì phản hồi lại cho người quản lý.</p>
								<p><b>-	Điểm danh chấm công</b> : Tương tự như chức năng của người trưởng phòng.</p>

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