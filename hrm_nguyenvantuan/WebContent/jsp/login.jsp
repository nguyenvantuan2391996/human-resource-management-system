<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login system</title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/csslogin.css">
<script src="js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="images/img-01.png" id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form method="post" action="login">
				<input type="text" id="username" class="fadeIn second" name="username"
					placeholder="login" required>
				<input type="password"
					id="password" class="fadeIn third" name="password"
					placeholder="password" required>
				<input type="submit"
					class="fadeIn fourth" value="Log In">
			</form>
			
			<!-- Error -->
			<p style="color: red">${error }</p>
			
			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>
</html>