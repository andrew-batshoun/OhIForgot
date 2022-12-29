<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Start of tags -->
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head>

<!-- tag for bootstrap and angular stylesheets -->
<tag:head />


<title>Log In</title>

<link rel="stylesheet" href="/resources/css/login.css">
</head>

<body ng-app="taskApp" class="ng-cloak">

	<!-- tag for navbar -->
	<tag:navbar />

	<div class="card text-center" ng-controller="AuthController as auth">

		<!-- Start of Login Form synchronous with backend no angular -->
		<form name="loginForm" class="form-signin" ng-submit="auth.loginSubmit()">
			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			<label for="username" class="sr-only">Username</label> 
			<input
				id="username" name="username" ng-model="username" type="text"
				class="form-control" placeholder="Username" required autofocus /> 
			<label
				for="password" class="sr-only">Password</label> 
			<input id="password"
				name="password" ng-model="password" type="password"
				class="form-control" placeholder="Password" required />
			<button class="btn btn-lg btn-info btn-block" id="submitLogin" type="submit">Sign
				in</button>



		</form>
	</div>

	<!-- tag for bootstrap and angular scripts with footer title -->
	<tag:footer></tag:footer>
	<script src="/resources/static/js/authController.js"></script>
	<script src="/resources/static/js/authService.js"></script>
</body>
</html>