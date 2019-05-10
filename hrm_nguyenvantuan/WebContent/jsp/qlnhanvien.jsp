<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard Admin</title>
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
			<a class="navbar-brand" href="dashboard_admin"> Administrator </a>
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
							<li><a href="dashboard_admin"><span
									class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
							<li><a href="phongban"><span
									class="glyphicon glyphicon-home"></span> Quản lý phòng ban </a></li>

							<!-- Dropdown-->
							<li class="panel panel-default" id="dropdown"><a
								data-toggle="collapse" href="#dropdown-lvl1"> <span
									class="glyphicon glyphicon-user"></span> Quản lý nhân sự <span
									class="caret"></span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-lvl1">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="qltruongphong">Quản lý trưởng phòng</a></li>
											<li class="active"><a href="qlnhanvien">Quản lý nhân
													viên</a></li>
											<li><a href="qlungvien">Quản lý ứng viên</a></li>
										</ul>
									</div>
								</div></li>

							<li><a href="qltienluong"><span
									class="glyphicon glyphicon-usd"></span> Quản lý tiền lương </a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse --> </nav>

				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Quản lý nhân viên</div>
				<p style="color: red">${msg }</p>
				<div class="panel-body">
					<div class="container">

						<!--Search-->
						<form class="navbar-form navbar-right" method="GET" role="search">
							<div class="form-group">
								<input type="text" name="search" class="form-control"
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
											<th>Năm Sinh</th>
											<th>Địa Chỉ</th>
											<th>Giới Tính</th>
											<th>Số Điện Thoại</th>
											<th>Tên Phòng Ban</th>
											<th>Trưởng Phòng</th>
											<th>Thêm</th>
											<th>Sửa</th>
											<th>Xóa</th>
										</thead>
										<tbody>
											<c:forEach items="${arrnv }" var="arrnv">
												<tr>
													<td>${arrnv.manv }</td>
													<td>${arrnv.hoten }</td>
													<td>${arrnv.namsinh }</td>
													<td>${arrnv.diachi }</td>
													<td>${arrnv.gioitinh }</td>
													<td>${arrnv.sdt }</td>
													<td>${arrnv.tenpb }</td>
													<td>${arrnv.tentp }</td>
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
																data-toggle="modal" data-target="#edit${arrnv.manv }">
																<span class="glyphicon glyphicon-pencil"></span>
															</button>
														</p></td>
													<td><p data-placement="top" data-toggle="tooltip"
															title="Delete">
															<button class="btn btn-danger btn-xs" data-title="Delete"
																data-toggle="modal" data-target="#delete${arrnv.manv }">
																<span class="glyphicon glyphicon-trash"></span>
															</button>
														</p></td>
												</tr>
												<!--Dialog add-->
												<form method="post" action="qlnhanvien">

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
																	<h4 class="modal-title custom_align" id="Heading">Thêm
																		mới thông tin nhân viên</h4>
																</div>
																<div class="modal-body">
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Họ & Tên" name="hotenadd" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="number" min="1900"
																			max="2099" step="1" placeholder="Năm Sinh"
																			name="namsinhadd" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Địa Chỉ" name="diachiadd" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Giới Tính" name="gioitinhadd" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Số Điện Thoại" name="sdtadd" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="number"
																			placeholder="Hệ Số Lương" name="hesoluongadd"
																			step="1000" required>
																	</div>

																	<div class="form-group">

																		<select required class="form-control" name="trinhdo">
																			<option value="">Vui lòng lựa chọn trình độ
																				tiếng Nhật</option>
																			<c:forEach items="${arrtn }" var="arrtn">
																				<option value="${arrtn.matn }">${arrtn.trinhdo }</option>
																			</c:forEach>
																		</select>
																	</div>

																	<div class="form-group">

																		<select required class="form-control" name="phongban">
																			<option value="">Vui lòng lựa chọn phòng ban</option>
																			<c:forEach items="${arrpb }" var="arrpb">
																				<option value="${arrpb.mapb }">${arrpb.tenpb }</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group">

																		<select required class="form-control"
																			name="truongphong">
																			<option value="">Vui lòng lựa chọn người
																				quản lý</option>
																			<c:forEach items="${arrtp }" var="arrtp">
																				<option value="${arrtp.matp }">${arrtp.hoten }</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Tên Tài Khoản" name="taikhoanadd"
																			required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="password"
																			placeholder="Mật Khẩu" name="matkhauadd" required>
																	</div>
																	<div class="form-group">
																		<input type="hidden" name="type" value="add">

																	</div>
																	<div class="form-group">
																		<input type="hidden" name="matn" value=${arrnv.matn }>

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
												<form method="post" action="qlnhanvien">
													<div class="modal fade" id="edit${arrnv.manv }"
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
																	<h4 class="modal-title custom_align" id="Heading">Chỉnh
																		sửa thông tin nhân viên</h4>
																</div>
																<div class="modal-body">
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Họ & Tên" value="${arrnv.hoten }"
																			name="hotenedit" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="number" min="1900"
																			max="2099" step="1" placeholder="Năm Sinh"
																			value="${arrnv.namsinh }" name="namsinhedit" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Địa Chỉ" value="${arrnv.diachi }"
																			name="diachiedit" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Giới Tính" value="${arrnv.gioitinh }"
																			name="gioitinhedit" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="text"
																			placeholder="Số Điện Thoại" value="${arrnv.sdt }"
																			name="sdtedit" required>
																	</div>
																	<div class="form-group">

																		<input class="form-control " type="number"
																			placeholder="Hệ Số Lương" name="hesoluongedit"
																			value="${arrnv.hesoluong }" step="1000" required>
																	</div>

																	<div class="form-group">

																		<select required class="form-control" name="trinhdo">
																			<option value="">Vui lòng lựa chọn trình độ
																				tiếng Nhật</option>
																			<c:forEach items="${arrtn }" var="arrtn">
																				<option value="${arrtn.matn }"
																					<c:if test="${arrtn.matn eq arrnv.matn }" >
																						selected="<c:out value="selected"></c:out>"
																					</c:if>>${arrtn.trinhdo }
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group">

																		<select required class="form-control" name="phongban">
																			<option value="">Vui lòng lựa chọn phòng ban</option>
																			<c:forEach items="${arrpb }" var="arrpb">
																				<option value="${arrpb.mapb }"
																					<c:if test="${arrpb.mapb eq arrnv.mapb }" >
																						selected="<c:out value="selected"></c:out>"
																					</c:if>>${arrpb.tenpb }
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group">

																		<select required class="form-control"
																			name="truongphong">
																			<option value="">Vui lòng lựa chọn trưởng
																				phòng</option>
																			<c:forEach items="${arrtp }" var="arrtp">
																				<option value="${arrtp.matp }"
																					<c:if test="${arrtp.matp eq arrnv.matp }" >
																						selected="<c:out value="selected"></c:out>"
																					</c:if>>${arrtp.hoten }
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group">
																		<input type="hidden" name="id" value=${arrnv.manv }>

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

												<!--Dialog delete-->
												<form method="post" action="qlnhanvien">
													<div class="modal fade" id="delete${arrnv.manv }"
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
																	<h4 class="modal-title custom_align" id="Heading">Xóa
																		Nhân Viên</h4>
																</div>
																<div class="form-group">
																	<input type="hidden" name="id" value=${arrnv.manv }>

																</div>
																<div class="form-group">
																	<input type="hidden" name="type" value="delete">

																</div>
																<div class="modal-body">

																	<div class="alert alert-danger">
																		<span class="glyphicon glyphicon-warning-sign"></span>
																		Bạn có thực sự muốn xóa hay không ?
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
												href="qlnhanvien?page=${listPage }">${listPage }</a></li>
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