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
							<li class="active"><a href="qlnghiphep"><span
									class="glyphicon glyphicon-signal"></span> Quản lý nghỉ phép </a></li>
							<li><a href="qlbaocao"><span
									class="glyphicon glyphicon-list-alt"></span> Quản lý báo cáo </a></li>

							<!-- Dropdown-->
							<li class="panel panel-default" id="dropdown"><a
								data-toggle="collapse" href="#dropdown-lvl1"> <span
									class="glyphicon glyphicon-calendar"></span> Tư vấn tuyển dụng
									<span class="caret"></span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-lvl1" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="danhgiaungvien">Đánh giá ứng viên</a></li>
											<li><a href="nhaptrongso">Xem tư vấn</a></li>
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
				<div class="panel-heading">Quản lý nghỉ phép</div>
				<p style="color: red">${msg }</p>
				<div class="panel-body">
					<div class="container">

						<!--Search-->
						<form class="navbar-form navbar-right" method="GET" role="search">
							<div class="form-group">
								<input type="text" name="q" class="form-control"
									placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</form>

						<!--Table Content-->
						<div class="row">

							<div class="col-md-12">
								<div class="table-responsive">

									<table id="mytable" class="table table-bordred table-striped">

										<thead>
											<th>ID</th>
											<th>Họ & Tên</th>
											<th>Loại Nghỉ Phép</th>
											<th>Ngày Nghỉ</th>
											<th>Lý Do</th>
											<th>Đồng Ý</th>
											<th>Không Đồng Ý</th>
										</thead>
										<tbody>
											<c:forEach items="${arrnp }" var="arrnp">

												<tr>
													<td>${arrnp.id }</td>
													<td>${arrnp.hoten }</td>
													<td>${arrnp.loainghiphep }</td>
													<td>${arrnp.ngaynghi }</td>
													<td>${arrnp.lydo }</td>
													<td><p data-placement="top" data-toggle="tooltip"
															title="Accept">
															<button class="btn btn-success btn-xs"
																data-title="Accept" data-toggle="modal"
																data-target="#accept${arrnp.id }">
																<span class="glyphicon glyphicon-ok"></span>
															</button>
														</p></td>
													<td><p data-placement="top" data-toggle="tooltip"
															title="No Accept">
															<button class="btn btn-primary btn-xs"
																data-title="No Accept" data-toggle="modal"
																data-target="#noaccept${arrnp.id }">
																<span class="glyphicon glyphicon-remove"></span>
															</button>
														</p></td>
												</tr>

												<!--Dialog accept-->
												<form method="post" action="qlnghiphep">
													<div class="modal fade" id="accept${arrnp.id }"
														tabindex="-1" role="dialog" aria-labelledby="edit"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">
																		<span class="glyphicon glyphicon-remove"
																			aria-hidden="true"></span>
																	</button>
																	<h4 class="modal-title custom_align" id="Heading">Chấp
																		nhận</h4>
																</div>
																<div class="modal-body">

																	<div class="form-group">
																		<input type="hidden" name="type" value="Accept">

																	</div>
																	<div class="form-group">
																		<input type="hidden" name="id" value=${arrnp.id }>

																	</div>

																	<div class="alert alert-danger">
																		<span class="glyphicon glyphicon-warning-sign"></span>
																		Bạn có thực sự muốn chấp nhận ?
																	</div>

																</div>
																<div class="modal-footer ">
																	<input type="submit" value="Yes"
																		class="btn btn-success"></input>
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">No</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
												</form>

												<!--Dialog no accept-->
												<form method="post" action="qlnghiphep">
													<div class="modal fade" id="noaccept" tabindex="-1"
														role="dialog" aria-labelledby="edit${arrnp.id }"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">
																		<span class="glyphicon glyphicon-remove"
																			aria-hidden="true"></span>
																	</button>
																	<h4 class="modal-title custom_align" id="Heading">Không
																		chấp nhận</h4>
																</div>
																<div class="modal-body">

																	<div class="form-group">
																		<input type="hidden" name="type" value="No Accept">

																	</div>
																	<div class="form-group">
																		<input type="hidden" name="id" value=${arrnp.id }>

																	</div>

																	<div class="alert alert-danger">
																		<span class="glyphicon glyphicon-warning-sign"></span>
																		Bạn có thực sự không chấp nhận ?
																	</div>

																</div>
																<div class="modal-footer ">
																	<input type="submit" value="Yes"
																		class="btn btn-success"></input>
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">No</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
												</form>

											</c:forEach>
										</tbody>

									</table>

									<!-- List page -->
									<div class="clearfix"></div>
									<ul class="pagination pull-right">
										<li class="disabled"><a href="#"><span
												class="glyphicon glyphicon-chevron-left"></span></a></li>
										<c:forEach items="${listPage }" var="listPage">
											<li <c:if test="${page eq listPage  }">class="active"</c:if>><a
												href="dangkynghiphep?page=${listPage }">${listPage }</a></li>
										</c:forEach>
										<li><a href="#"><span
												class="glyphicon glyphicon-chevron-right"></span></a></li>
									</ul>

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