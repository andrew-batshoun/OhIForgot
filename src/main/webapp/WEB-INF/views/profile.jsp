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
<body>
	<tag:navbar></tag:navbar>
	<main class ="card text-center">
	<h4>Edit Profile</h4>
	<br>
	<form>
		<div class="mb-3 row">
			<input type="hidden" name="id"> 
			<label for="username">Username</label>
			<input type="text" id="username" name="username">
		</div>

		<div class="mb-3 row">
			<label for="email">Email</label> 
			<input type="email" id="email" />
		</div>
		<div class="mb-3 row">
			<label for="password">Password</label> 
			<input type="password"
				id="password" name="password">
		</div>

		<button class="btn btn btn-primary" type="submit">
		Submit Changes</button>

		<button type="submit" id="profile-delete" class="btn btn btn-danger">
		Delete Profile</button>
		
	</form>
	</main>




	<tag:footer></tag:footer>
</body>
</html>