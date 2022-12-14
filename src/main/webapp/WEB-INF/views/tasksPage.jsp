<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<tag:head />
<!-- tag for bootstrap and angular stylesheets -->

<title>Task list</title>
</head>

<!-- Starts angular -->
<body ng-app="taskApp" class="ng-cloak">

	<tag:navbar />
	<!-- tag for navbar -->

	<!--div with ng controller   -->
	<div class="container" ng-controller="TasksController as ctrl"
		style="margin: 1em">

		<div class="panel panel-default">
			<div class="panel-Heading">
				<span class="lead">List of Tasks</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Task #</th>
							<th>Task Description</th>
							<th>DueDate</th>
							<th>Completed</th>
							<th width="20%"></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<!-- repeats tasks, uses template located below at scripts element  -->
						<tr ng-repeat="currentTask in ctrl.tasks"
							ng-include="getTemplate(currentTask)">

						</tr>
					</tbody>
				</table>
			</div>
			<!-- Activates Model for adding a task, will not show when editing task -->
			<input ng-show="!ctrl.task.id" class="btn btn-primary" id="addTask"
				value="New Task" type="button" data-bs-toggle="collapse"
				data-bs-target="#collapseCreateTask" aria-expanded="false"
				aria-controls="collapseCreateTask">

		</div>

		<!--Model for adding task  -->
		<div ng-show="!ctrl.task.id" class="collapse" id="collapseCreateTask">
			<div class="card card-body">
				<div class="panel panel-default">

					<!--Form for adding task in Model -->
					<div class="formcontainer">
						<form ng-submit="ctrl.submit()" name="taskForm"
							class="form-horizontal">
							<input type="hidden" ng-model="ctrl.task.id" />
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="description">Description</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.task.description"
											id="description" class=" form-control input-sm"
											placeholder="Enter a task description" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="date">Due
										Date</label>
									<div class="col-md-7">
										<input type="date" ng-model="ctrl.task.dueDate" id="date"
											class="form-control input-sm"
											placeholder="Enter a due date. " />
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="form-actions floatRight">
									<input type="submit" id="submitTask" value="Add"
										class="btn btn-primary btn-sm">
									<button type="button" ng-click="ctrl.reset()"
										class="btn btn-warning btn-sm"
										ng-disabled="taskForm.$pristine">Reset</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- tag for bootstrap and angular scripts with footer title -->
	<tag:footer></tag:footer>

	<!-- angular controller and service for tasks -->
	<script src="/resources/static/js/taskService.js"></script>
	<script src="/resources/static/js/taskController.js"></script>

	<!-- Script for showing task and for inline editing  -->
	<script type="text/ng-template" id="display">
	<td><span ng-bind="currentTask.id"></span></td>
							<td><span id="description-{{$index}}" ng-bind="currentTask.description"></span></td>
							<td><span id="date-{{$index}}" ng-bind="currentTask.dueDate | date:'MM/dd/yyyy'  "></span></td>
							<td><input type="checkbox" ng-change="showRemove()"
								ng-model="checkSelected" id="checkBox-{{$index}}"></td>
							<td>

								<div ng-show="checkSelected">
									<button type="button" ng-click="ctrl.remove(currentTask.id)"
										class="btn btn-danger custom-width" id="removeTask-{{$index}}">Remove</button>
								</div>
							</td>
							<td>
								<div>
									<button type="button" ng-click="ctrl.edit(currentTask.id)"
										class="btn btn-success custom-width" id="editTask-{{$index}}" >Edit</button>
								</div>

							</td>
	
	</script>
	<script type="text/ng-template" id="edit">
	<td><span ng-bind="currentTask.id"></span></td>
							<td><input id="descriptionEdit-{{$index}}" ng-model="ctrl.task.description" required/><span ng-show="ctrl.task.description.$invalid && ctrl.task.description.$touched" style="color: red">Please Enter a Description</span></td>
							<td><input id="dateEdit-{{$index}}" type ="date" ng-model="ctrl.task.dueDate "/></td>
							<td><input type="checkbox" ng-change="showRemove()"
								ng-model="checkSelected"></td>
							<td>
								
							</td>
							<td>
								<div>
									<button type="button" ng-click="updateSubmit()"
										class="btn btn-danger custom-width" id="submitEdit-{{$index}}" ng-disabled="ctrl.task.description.$invalid">Save</button>
									<button type="button" ng-click="ctrl.reset()"
										class="btn btn-primary custom-width" id="cancelEdit-{{$index}}">Cancel</button>
								</div>

							</td>
	
	</script>


</body>
</html>