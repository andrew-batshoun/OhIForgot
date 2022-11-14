<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

<tag:head/>

<title>Task list</title>

</head>
<body ng-app="taskApp" class="ng-cloak">
<tag:navbar/>
	<div class="container" ng-controller="TasksController as ctrl">
		<div class="panel panel-default">
			<div class="panel-Heading">
				<span class="lead">List of Tasks</span>
			</div>
			<div class="tablecontainer">
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
							<td><span ng-bind="currentTask.id"></span></td>
							<td><span ng-bind="currentTask.description"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>


	<tag:footer></tag:footer>
</body>
</html>