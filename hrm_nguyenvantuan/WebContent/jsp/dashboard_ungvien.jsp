<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
	<title>Dashboard Candidate</title>
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
				<a class="navbar-brand" href="dashboard_ungvien.html">
					Candidate
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
				<form class="navbar-form navbar-left" method="GET" role="search">
					<div class="form-group">
						<input type="text" name="q" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
				</form>
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
								<li><a href="login.html"><i class="glyphicon glyphicon-log-out"></i> Logout</a></li>
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
									<li class="active"><a href="#"><span class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
									<li><a href="thitest.html"><span class="glyphicon glyphicon-home"></span> Thi test </a></li>
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
							<b><p align="center">Ứng viên được cấp tài khoản truy cập vào hệ thống và có các chức năng trong hệ thống như sau : </p></b>
							<p><b>-	Nhận dạng thông tin </b>: Khi tác nhân truy cập vào link hệ thống, hệ thống sẽ yêu cầu nhận dạng thông tin bằng nhận diện khuôn mặt để kiểm tra thông tin tác nhân có tồn tại trong cơ sở dữ liệu hay không.</p>
							<p><b>-	Đăng nhập</b> : Sau khi nhận dạng thông tin thành công, tác nhân được chuyển tới trang đăng nhập để truy cập vào hệ thống. Tác nhân phải đăng nhập chính xác thông tin tài khoản vừa được nhận diện ở trước đó.</p>
							<p><b>-	Thi test</b> : Sau khi đăng nhập thành công, tác nhân được truy cập vào chức năng làm bài thi. Kết quả này sẽ được lưu lại để phục vụ cho việc tư vấn tuyển dụng.</p>
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