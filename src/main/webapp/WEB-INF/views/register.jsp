<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<tag:head />
<meta charset="UTF-8" />
<title>Log In</title>
<link rel="stylesheet" href="/resources/login.css">
</head>
<body ng-app="taskApp" class="ng-cloak">
	<div class="container" ng-controller="RegisterController as ctrl"
		style="margin: 1em">
		
		<form ng-submit="ctrl.submit()" name="userForm"
							class="form-horizontal">
							<input type="text" ng-model="ctrl.user.id" />
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
										<input type="text" ng-model="ctrl.user.email" id="email"
											class="form-control input-sm"
											placeholder="Enter an Email " />
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
											placeholder="Enter Password " />
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


<!-- bootstrap -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

<!-- angularjs library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-messages.min.js"></script>

<!-- Angular Material Library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.12/angular-material.min.js"></script>

	<script src="/resources/static/js/app.js"></script>
	<script src="/resources/static/js/registerController.js"></script>
	<script src="/resources/static/js/registerService.js"></script>
</body>
</html>