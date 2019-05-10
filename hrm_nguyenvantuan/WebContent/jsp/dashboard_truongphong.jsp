<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
	<title>Dashboard Manager</title>
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
				<a class="navbar-brand" href="dashboard_truongphong.html">
					Manager
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
									<li class="active"><a href="dashboard_truongphong"><span class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
									<li><a href="qlot"><span class="glyphicon glyphicon-time"></span> Quản lý OT </a></li>
									<li><a href="nhanvien"><span class="glyphicon glyphicon-user"></span> Quản lý nhân viên </a></li>
								 		<li><a href="qlnghiphep"><span class="glyphicon glyphicon-signal"></span> Quản lý nghỉ phép </a></li>
									<li><a href="qlbaocao"><span class="glyphicon glyphicon-list-alt"></span> Quản lý báo cáo </a></li>

									<!-- Dropdown-->
									<li class="panel panel-default" id="dropdown">
										<a data-toggle="collapse" href="#dropdown-lvl1">
											<span class="glyphicon glyphicon-calendar"></span> Tư vấn tuyển dụng <span class="caret"></span>
										</a>

										<!-- Dropdown level 1 -->
										<div id="dropdown-lvl1" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="nav navbar-nav">
													<li><a href="danhgiaungvien">Đánh giá ứng viên</a></li>
													<li><a href="nhaptrongso">Xem tư vấn</a></li>
												</ul>
											</div>
										</div>
									</li>
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
							<p align="center"><b>Người trưởng phòng có một tài khoản riêng để đăng nhập vào trang quản lý dành cho trưởng phòng và có các chức năng sau :</b></p>
							<p><b>- Chức năng tư vấn tuyển dụng</b> : Mục đích của chức năng này là gợi ý cho tác nhân lựa chọn tốt nhất các ứng viên sau khi phỏng vấn. Các kết qua đánh giá từng tiêu chí cho từng ứng viên được lấy từ kết quả phỏng vấn và điểm thi làm bài test của các ứng viên. Sau khi có các kết quả đánh giá, tác nhân xem tư vấn để lựa chọn ứng viên tốt nhất.</p>
							<p><b>- Điểm danh chấm công</b> : Mục đích của chức năng này là tránh việc điểm danh chấm công hộ cho nhau. Sau khi, tác nhân vào link hệ thống, tác nhân được camera chụp 1 ảnh để hệ thống nhận dạng thông tin. Sau khi hệ thống trả về dự đoán, tác nhân xác nhận thông tin được dự đoán. Khi đó, hệ thống sẽ chấm công và tác nhân được chuyển tới trang đăng nhập vào hệ thống.</p>
							<p><b>- Quản lý nhân viên, OT, nghỉ phép, báo cáo</b> : Trưởng phòng có thể tra cứu thông tin về nhân viên, báo cáo của nhân viên gửi hằng ngày, chấp nhận hoặc không chấp nhận cho nhân viên OT, nghỉ phép.</p>
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