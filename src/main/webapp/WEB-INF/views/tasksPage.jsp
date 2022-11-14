<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<tag:head />

<title>Task list</title>

</head>
<body ng-app="taskApp" class="ng-cloak">

	<tag:navbar />
	
	<div class="container" ng-controller="TasksController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Add a Task </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.saveTask()" name="taskForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.task.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="descript">Description</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.task.description"
									id="descript" class=" form-control input-sm"
									placeholder="Enter a task description" required
									ng-minlength="3" />
								<div class="has-error" ng-show="taskForm.$dirty">
									<span ng-show="taskForm.descript.$error.required">This
										is a required field</span> <span
										ng-show="taskForm.descript.$error.minlength">Minimum
										length required is 3</span> <span
										ng-show="taskForm.descript.$invalid">This field is
										invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" class="btn btn-primary btn-sm"
								ng-disabled="taskForm.$invalid">
							<!--            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button> -->
						</div>
					</div>
				</form>
			</div>
		</div>
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