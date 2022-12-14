<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- insert Tags -->
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head>

<!-- tag for bootstrap and angular stylesheets -->
<tag:head />


<title>Register</title>

<link rel="stylesheet" href="/resources/css/register.css">
</head>

<!-- Start of angularjs -->
<body ng-app="taskApp" class="ng-cloak">

<!-- tag for navbar -->
<tag:navbar/>
	
	<br>
	
	<div class =" reg-form"  ng-controller="AuthController as ctrl"
		>
		<h4>Create an Account</h4>
		
		<br>
		
		<!-- Start of register form -->
		<form ng-submit="ctrl.submit()" name="userForm"
							class="form-horizontal">
							<input type="hidden" ng-model="ctrl.user.id" />
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="username">Username</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.user.username"
											id="username" class=" form-control input-sm"
											placeholder="Enter a Username" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="email">Email
										</label>
									<div class="col-md-7">
										<input type="email" ng-model="ctrl.user.email" id="email"
											class="form-control input-sm"
											placeholder="Enter an Email " required/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="password">Password
										</label>
									<div class="col-md-7">
										<input type="password" ng-model="ctrl.user.password" id="password"
											class="form-control input-sm"
											placeholder="Enter Password " required />
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="form-actions floatRight">
									<input type="submit" value="Sign up" class="btn btn-primary btn-sm">	
								</div>
							</div>
						</form>
		</div>


<!-- Register controller and service  -->
<tag:footer></tag:footer>
	<!-- auth controller with service -->
<script src="/resources/static/js/authController.js"></script>
<script src="/resources/static/js/authService.js"></script>
</body>
</html>