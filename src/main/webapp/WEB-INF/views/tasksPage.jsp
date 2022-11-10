<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang= "en">

<head>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.12/angular-material.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
<title>Task list</title>
		
</head>
<body ng-app="taskApp" class="ng-cloak">
<div class="container" ng-controller="TasksController as ctrl">
	<div class = "panel panel-default">
	<div class ="panel-Heading"><span class="lead">List of Tasks</span></div>
	<div class = "tablecontainer">
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Task Id</th>
			<th>Task Description</th>
			<th width="20%"></th>	
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="currentTask in ctrl.tasks">
			<td><span ng-bind ="currentTask.id"></span></td>
			<td><span ng-bind ="currentTask.description"></td>
			
	
		</tr>
	</tbody>
	</table>
	</div>
	</div>
	
</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-messages.min.js"></script>

  <!-- Angular Material Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.12/angular-material.min.js"></script>
	<script src="/resources/static/js/app.js" ></script>
	<script src="/resources/static/js/taskService.js"></script>
	<script src="/resources/static/js/taskController.js"></script>
</body>
</html>