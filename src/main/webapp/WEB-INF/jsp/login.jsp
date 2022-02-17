<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Log in Tirage</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../../resources/Login_v14/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/css/util.css">
	<link rel="stylesheet" type="text/css" href="../../resources/Login_v14/css/main.css">
<!--===============================================================================================-->
</head>
<body>
<sec:authorize access="isAuthenticated()">
	<% response.sendRedirect("/"); %>
</sec:authorize>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form method="POST" action="/login" class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-32">
						Account Login
					</span>

					<span class="txt1 p-b-11">
						Username
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "Phonenumber is required">
						<input class="input100" modelAtribute="userName" name="username" type="text" placeholder="Username"
							   autofocus="true">
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Password
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
<%--							<i class="fa fa-eye"></i>--%>
						</span>
						<input class="input100" name="password" type="password" placeholder="Password" >
						<span class="focus-input100"></span>
					</div>
					
<%--					<div class="flex-sb-m w-full p-b-48">--%>
<%--						<div class="contact100-form-checkbox">--%>
<%--							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">--%>
<%--							<label class="label-checkbox100" for="ckb1">--%>
<%--								Remember me--%>
<%--							</label>--%>
<%--						</div>--%>

<%--						<div>--%>
<%--							<a href="#" class="txt3">--%>
<%--								Forgot Password?--%>
<%--							</a>--%>
<%--						</div>--%>
<%--					</div>--%>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							Login
						</button>
						<h4><a href="/">Главная</a></h4>
					</div>
				</form>
			</div>
		</div>
	</div>
	

<%--	<div id="dropDownSelect1"></div>--%>
	
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/vendor/bootstrap/js/popper.js"></script>
	<script src="../../resources/Login_v14/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/vendor/daterangepicker/moment.min.js"></script>
	<script src="../../resources/Login_v14/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="../../resources/Login_v14/js/main.js"></script>

</body>
</html>