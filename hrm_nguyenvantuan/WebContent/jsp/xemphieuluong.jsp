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
                <li><a href="login.html"><i class="glyphicon glyphicon-log-out"></i> Logout</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>    <div class="container-fluid main-container">
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
                  <li><a href="dashboard_nhanvien.html"><span class="glyphicon glyphicon-dashboard"></span> Dashboard </a></li>
                  <li><a href="baocaonv.html"><span class="glyphicon glyphicon-list-alt"></span> Báo cáo </a></li>
                  <li><a href="dangkyot.html"><span class="glyphicon glyphicon-time"></span> Đăng ký OT </a></li>
                  <li><a href="dangkynghiphep.html"><span class="glyphicon glyphicon-signal"></span> Đăng ký nghỉ phép </a></li>
                  <li class="active"><a href="xemphieuluong.html"><span class="glyphicon glyphicon-usd"></span> Xem phiếu lương </a></li>
                </ul>
              </div><!-- /.navbar-collapse -->
            </nav>

          </div>
        </div>      </div>
        <div class="col-md-10 content">
          <div class="panel panel-default">
            <div class="panel-heading">
              Xem phiếu lương
            </div>
            <div class="panel-body">
              <div class="container">

                <!--Search-->
                <form class="navbar-form navbar-right" method="GET" role="search">
                  <div class="form-group">
                    <input type="text" name="q" class="form-control" placeholder="Search">
                  </div>
                  <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                </form>

                <!--Table Content-->
                <div class="row">

                  <div class="col-md-12">
                    <div class="table-responsive">

                      <table id="mytable" class="table table-bordred table-striped">

                       <thead>
                         <th>ID</th>
                         <th>Họ & Tên</th>
                         <th>Lương Cơ Bản</th>
                         <th>Số Giờ Công</th>
                         <th>Số Giờ OT</th>
                         <th>Số Ngày Nghỉ</th>
                         <th>Tháng</th>
                         <th>Tổng Lương</th>
                         <th>Xác Nhận</th>
                       </thead>
                       <tbody>

                        <tr>
                          <td>1</td>
                          <td>Nguyen Van Tuan</td>
                          <td>20000000</td>
                          <td>95</td>
                          <td>9</td>
                          <td>9</td>
                          <td>9</td>
                          <td></td>
                          <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-primary btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-ok"></span></button></p></td>

                        </tr>

                        <tr>
                          <td>2</td>
                          <td>Nguyen Van Tuan</td>
                          <td>20000000</td>
                          <td>95</td>
                          <td>9</td>
                          <td>9</td>
                          <td>10</td>
                          <td></td>
                          <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-primary btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-ok"></span></button></p></td>

                        </tr>

                      </tbody>

                    </table>

                    <div class="clearfix"></div>
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
            </div>

            <!--Dialog delete-->
            <form method="post" action="#">
              <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                    </div>
                    <div class="modal-body">

                     <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Xác nhận phiếu lương</div>

                   </div>
                   <div class="modal-footer ">
                    <input type="submit" value="Yes" class="btn btn-success" ></input>
                    <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                  </div>
                </div>
                <!-- /.modal-content --> 
              </div>
              <!-- /.modal-dialog --> 
            </div>
          </form>

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