<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
                                <li><a href="login.html"><i class="glyphicon glyphicon-log-out"></i> Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>      <div class="container-fluid main-container">
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
                                    <li><a href="dashboard_truongphong.html"><span class="glyphicon glyphicon-dashboard"></span> Dashbroad </a></li>
                                    <li><a href="ot.html"><span class="glyphicon glyphicon-time"></span> Quản lý OT </a></li>
                                    <li><a href="nhanvien.html"><span class="glyphicon glyphicon-user"></span> Quản lý nhân viên </a></li>
                                    <li><a href="nghiphep.html"><span class="glyphicon glyphicon-signal"></span> Quản lý nghỉ phép </a></li>
                                    <li class="active"><a href="baocao.html"><span class="glyphicon glyphicon-list-alt"></span> Quản lý báo cáo </a></li>

                                    <!-- Dropdown-->
                                    <li class="panel panel-default" id="dropdown">
                                        <a data-toggle="collapse" href="#dropdown-lvl1">
                                            <span class="glyphicon glyphicon-calendar"></span> Tư vấn tuyển dụng <span class="caret"></span>
                                        </a>

                                        <!-- Dropdown level 1 -->
                                        <div id="dropdown-lvl1" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="danhgiaungvien.html">Đánh giá ứng viên</a></li>
                                                    <li><a href="xemtuvan.html">Xem tư vấn</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div><!-- /.navbar-collapse -->
                        </nav>

                    </div>
                </div>          </div>
                <div class="col-md-10 content">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Quản lý báo cáo
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
                                                 <th>Dự Án</th>
                                                 <th>Nội dung báo cáo</th>
                                                 <th>Ngày</th>
                                             </thead>
                                             <tbody>

                                                <tr>
                                                    <td>1</td>
                                                    <td>Nguyen Van Tuan</td>
                                                    <td>WEB</td>
                                                    <td>Hoàn thành task</td>
                                                    <td>29/09/2019</td>
                                                </tr>

                                                <tr>
                                                    <td>2</td>
                                                    <td>Nguyen Van Tuan</td>
                                                    <td>Android</td>
                                                    <td>Hoàn thành task</td>
                                                    <td>29/09/2019</td>                                                    
                                                </tr>


                                                <tr>
                                                    <td>3</td>
                                                    <td>Nguyen Van Tuan</td>
                                                    <td>App Desktop</td>
                                                    <td>Hoàn thành 80 % task</td>
                                                    <td>29/09/2019</td>
                                                </tr>



                                                <tr>
                                                    <td>4</td>
                                                    <td>Nguyen Van Tuan</td>
                                                    <td>WEB</td>
                                                    <td>Hoàn thành 90% task</td>
                                                    <td>29/09/2019</td>

                                                </tr>


                                                <tr>
                                                    <td>5</td>
                                                    <td>Nguyen Van Tuan</td>
                                                    <td>WEB</td>
                                                    <td>Hoàn thành 95% task</td>
                                                    <td>29/09/2019</td>

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