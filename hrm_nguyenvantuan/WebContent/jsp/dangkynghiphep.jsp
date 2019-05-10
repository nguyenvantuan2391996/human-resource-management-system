<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard Employee</title>
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
			<a class="navbar-brand" href="dashboard_nhanvien.html"> Employee
			</a>
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
							<li><a href="dashboard_nhanvien"><span
									class="glyphicon glyphicon-dashboard"></span> Dashboard </a></li>
							<li><a href="baocaonv"><span
									class="glyphicon glyphicon-list-alt"></span> Báo cáo </a></li>
							<li><a href="dangkyot"><span
									class="glyphicon glyphicon-time"></span> Đăng ký OT </a></li>
							<li class="active"><a href="dangkynghiphep"><span
									class="glyphicon glyphicon-signal"></span> Đăng ký nghỉ phép </a></li>
							<li><a href="xemphieuluong"><span
									class="glyphicon glyphicon-usd"></span> Xem phiếu lương </a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse --> </nav>

				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Đăng ký nghỉ phép</div>
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
											<th>Xác Nhận</th>
											<th>Thêm</th>
											<th>Sửa</th>
										</thead>
										<tbody>
											<c:forEach items="${arrnp }" var="arrnp">
												<tr>
													<td>${arrnp.id }</td>
													<td>${arrnp.hoten }</td>
													<td>${arrnp.loainghiphep }</td>
													<td>${arrnp.ngaynghi }</td>
													<td>${arrnp.lydo }</td>
													<td>${arrnp.xacnhan }</td>
													<td><p data-placement="top" data-toggle="tooltip"
															title="Add">
															<button class="btn btn-success btn-xs" data-title="Add"
																data-toggle="modal" data-target="#add">
																<span class="glyphicon glyphicon-plus"></span>
															</button>
														</p></td>
													<td><p data-placement="top" data-toggle="tooltip"
															title="Edit">
															<button class="btn btn-primary btn-xs" data-title="Edit"
																data-toggle="modal" data-target="#edit${arrnp.id }">
																<span class="glyphicon glyphicon-pencil"></span>
															</button>
														</p></td>

												</tr>
												<!--Dialog add-->
												<form method="post" action="dangkynghiphep">

													<div class="modal fade" id="add" tabindex="-1"
														role="dialog" aria-labelledby="add" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">
																		<span class="glyphicon glyphicon-remove"
																			aria-hidden="true"></span>
																	</button>
																	<h4 class="modal-title custom_align" id="Heading">Đăng
																		ký nghỉ phép</h4>
																</div>
																<div class="modal-body">

																	<div class="form-group">

																		<select required class="form-control"
																			name="loainghiphep">
																			<option value="">Vui lòng lựa chọn loại nghỉ
																				phép</option>
																			<option value="Sáng">Sáng</option>
																			<option value="Chiều">Chiều</option>
																			<option value="Cả Ngày">Cả Ngày</option>
																		</select>
																	</div>

																	<div class="form-group">

																		<input class="form-control " type="date"
																			placeholder="Ngày đăng ký đăng ký nghỉ phép"
																			name="ngaynghiadd" required>
																	</div>

																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Lý do" name="lydoadd" required>
																	</div>
																	<div class="form-group">
																		<input type="hidden" name="type" value="add">

																	</div>
																</div>
																<div class="modal-footer ">
																	<input type="submit" value="Xác nhận"
																		class="btn btn-warning btn-lg" style="width: 100%;"></input>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
												</form>

												<!--Dialog edit-->
												<form method="post" action="dangkynghiphep">
													<div class="modal fade" id="edit${arrnp.id }" tabindex="-1"
														role="dialog" aria-labelledby="edit" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">
																		<span class="glyphicon glyphicon-remove"
																			aria-hidden="true"></span>
																	</button>
																	<h4 class="modal-title custom_align" id="Heading">Sửa
																		báo cáo</h4>
																</div>
																<div class="modal-body">
																	<div class="modal-body">

																		<div class="form-group">

																			<select required class="form-control"
																				name="loainghiphep">
																				<option value="">Vui lòng lựa chọn loại
																					nghỉ phép</option>
																				<option value="Sáng" selected="selected">Sáng</option>
																				<option value="Chiều">Chiều</option>
																				<option value="Cả Ngày">Cả ngày</option>
																			</select>
																		</div>

																		<div class="form-group">

																			<input class="form-control " type="date"
																				placeholder="Ngày đăng ký đăng ký nghỉ phép" name="ngaynghiedit" value="${arrnp.ngaynghi }"
																				required>
																		</div>

																		<div class="form-group">

																			<input class="form-control " type="text"
																				placeholder="Lý do" name="lydoedit" value="${arrnp.lydo	 }" required>
																		</div>
																		<div class="form-group">
																		<input type="hidden" name="manp" value=${arrnp.id }>

																	</div>
																	<div class="form-group">
																		<input type="hidden" name="type" value="edit">

																	</div>
																	</div>
																	<div class="modal-footer ">
																		<input type="submit" value="Xác nhận"
																			class="btn btn-warning btn-lg" style="width: 100%;"></input>
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