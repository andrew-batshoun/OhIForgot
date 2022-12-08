<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<tag:head></tag:head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="/resources/css/profile.css">
</head>
<body ng-app= "taskApp" class="ng-cloak">
	<tag:navbar></tag:navbar>
	<main class ="card text-center" ng-controller="ProfileController as ctrl">
	<h4>Edit Profile</h4>
	<br>
	<form ng-submit="ctrl.submit()">
		<div class="mb-3 row">
			<input type="hidden" name="id" ng-model="ctrl.user.id"> 
			<label for="username">Username</label>
			<input type="text" id="username" name="username" ng-model="ctrl.user.username" required>
		</div>

		<div class="mb-3 row">
			<label for="email">Email</label> 
			<input type="email" id="email" ng-model="ctrl.user.email" required />
		</div>
		<div class="mb-3 row">
			<label for="password">Password</label> 
			<input type="password"
				id="password" name="password" ng-model="ctrl.user.password" required>
		</div>

		<button class="btn btn btn-primary" type="submit">
		Submit Changes</button>
		
	</form>
	<button type="submit" id="profile-delete" class="btn btn btn-danger" ng-click="ctrl.remove(ctrl.user.id)">
		Delete Profile</button>
	</main>



	
	<tag:footer></tag:footer>
	<script src="/resources/static/js/profileController.js"></script>
	<script src="/resources/static/js/profileService.js"></script>
</body>
</html>