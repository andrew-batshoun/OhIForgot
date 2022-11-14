<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML >

<html>
<head>
<tag:head />
<title>Create a Task</title>
</head>
<body class="container" >
	<tag:navbar />
	<form class="w-75">
		<div class="mb-3">
			<label for="description" class="form-label">Task Description
				</label> <input type="text" class="form-control"
				id="description" aria-describedby="description">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<tag:footer />
</body>

</html>