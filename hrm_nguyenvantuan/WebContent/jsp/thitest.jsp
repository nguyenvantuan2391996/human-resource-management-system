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
									<li><a href="dashboard_ungvien.html"><span class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
									<li class="active"><a href="thitest.html"><span class="glyphicon glyphicon-home"></span> Thi test </a></li>
								</ul>
							</div><!-- /.navbar-collapse -->
						</nav>

					</div>
				</div>  		</div>
				<div class="col-md-10 content">
					<div class="panel panel-default">
						<div class="panel-heading">
							Chúc bạn làm bài thi với kết quả tốt nhất
						</div>
						<div class="panel-body">
							<form>
								<h4>Chủ đề : Quản trị dự án</h4><br>
								<p><b>Câu 1 : Phát triển nhóm trong giai đoạn nào của tiến trình DA</b></p><br>
								<label class="radio-inline">
									<input type="radio" name="optradio">Kiểm soát
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Hoạch định
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Khởi sự DA
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Thực hiện
								</label>
							</form>

							<form action="thitest_submit" method="get" accept-charset="utf-8">
								<p><br><b>Câu 2 : Một nhà quản trị DA vừa trở thành nhà quản lý cho một dự án. tài liệu công nhận sự tồntại của dự án gọi là</b><br></p><br>
								<label class="radio-inline">
									<input type="radio" name="optradio">Phân công dự án
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Hiến chương dự án
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Báo cáo công việc
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Mô tả sản phẩm
								</label>
							</form>

							<form action="thitest_submit" method="get" accept-charset="utf-8">
								<p><br><b>Câu 3 : Một nhà quản trị DA vừa trở thành nhà quản lý cho một dự án. tài liệu công nhận sự tồntại của dự án gọi là</b><br></p><br>
								<label class="radio-inline">
									<input type="radio" name="optradio">Phân công dự án
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Hiến chương dự án
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Báo cáo công việc
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Mô tả sản phẩm
								</label>
							</form>

							<form action="thitest_submit" method="get" accept-charset="utf-8">
								<p><br><b>Câu 4 : Yếu tố nào sau đây không phải là một kỹ năng quản trị tác nghiệp Choose one answer</b>b<br></p><br>
								<label class="radio-inline">
									<input type="radio" name="optradio">Quản trị rủi ro
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Truyền thông
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Chương trình hóa
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Giải quyết vấn đề nguồn nhân lực
								</label>
							</form>

							<form action="thitest_submit" method="get" accept-charset="utf-8">
								<p><br><b>Câu 5 : Chi phí nguyên đầu vào tăng phát sinh nhu cầu dự án nghiên cứu nguyên vật liệu thaythế, thuộc về sự thay đổi</b><br></p><br>
								<label class="radio-inline">
									<input type="radio" name="optradio">Khả năng của doanh nghiệp
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Từ yêu cầu pháp lý
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Từ yêu cầu khách hàng
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Từ môi trường kinh doanh
								</label>
							</form>

							<ul class="pagination pull-right">
								<li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
							</ul>
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