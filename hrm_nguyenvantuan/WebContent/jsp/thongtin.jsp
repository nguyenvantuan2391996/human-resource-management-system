<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
    <title>Thông tin nhận diện</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/thongtin.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <img src="E:\Picture\anh.jpg" alt="" class="img-rounded img-responsive" />
                        </div>
                        <div class="col-sm-8 col-md-8">
                            <h4>Tuan Nguyen Van</h4>
                            <small><cite title="San Francisco, USA">Ha Noi, Viet Nam <i class="glyphicon glyphicon-map-marker">
                            </i></cite></small>
                            <p>
                                <i class="glyphicon glyphicon-envelope"></i>email@example.com
                                <br />
                                <i class="glyphicon glyphicon-globe"></i><a href="http://www.jquery2dotnet.com">www.jquery2dotnet.com</a>
                                <br />
                                <i class="glyphicon glyphicon-gift"></i>Sep 23, 1996
                                <br />
                                <i class="glyphicon glyphicon-globe"></i> Mã nhân viên: NV999
                                <br />
                                <i class="glyphicon glyphicon-globe"></i> SĐT: 0965651574
                                <br />
                                <i class="glyphicon glyphicon-globe"></i> Giới tính: Nam</p>

                                <!--button -->
                                <div class="btn-group">
                                    <form method="get" action="login.html">
                                        <ul class="pagination pull-right">
                                            <li><input type="submit" value="Xác nhận" class="btn btn-primary"></li>
                                            <li><input type="submit" value="Quay lại" class="btn btn-primary"></li>
                                        </ul>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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