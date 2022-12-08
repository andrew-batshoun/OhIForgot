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

<body>

<!-- tag for navbar -->
<tag:navbar/>

	<div class="card text-center">
	
	<!-- Start of Login Form synchronous with backend no angular -->
		<form class="form-signin" action="/login/" method="POST">
			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			<label for="username" class="sr-only">Username</label> 
			<input
				id="username" name="username" type="text" class="form-control"
				placeholder="Username" required autofocus /> 
			<label for="password"
				class="sr-only">Password</label> 
			<input id="password"
				name="password" type="password" class="form-control"
				placeholder="Password" required />
			<button class="btn btn-lg btn-info btn-block" type="submit">Sign
				in</button>
			<div id="error" >${error}</div>
		</form>
	</div>

	<!-- tag for bootstrap and angular scripts with footer title -->
	<tag:footer></tag:footer>
</body>
</html>