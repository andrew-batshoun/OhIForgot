<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang= "en">

<head>
		<script src="resources/static/js/app.js" ></script>
        <script src="resources/static/js/service.js"></script>
        <script src="resources/static/js/taskController.js"></script>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
<title>Task list</title>
		
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="container" ng-controller="TaskController as ctrl">
	<div class="tablecontainer">
		<table class="table table-dark table-striped text-light">
			<thead>
				<tr>
					<th>Task Id</th>
					<th>Task Description</th>
					<th>Task Start Date</th>
					<th>isCompleted</th>
					<th width="20%"></th>	
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="currentTask in ctrl.tasks">
					<td><span ng-bind ="currentTask.id"></span></td>
					<td><span ng-bind ="currentTask.description"></td>
					<td><span ng-bind ="currentTask.startDate"></td>
					<td><span ng-bind ="currentTask.isComplete"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>