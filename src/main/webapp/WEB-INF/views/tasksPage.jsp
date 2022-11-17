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

	<div class="container" ng-controller="TasksController as ctrl" style="margin: 1em">

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
						<tr ng-repeat="currentTask in ctrl.tasks">
							<td><span ng-bind="currentTask.id"></span></td>
							<td><span ng-bind="currentTask.description"></span></td>
							<td><span ng-bind="currentTask.dueDate"></span></td>
							<td><input type="checkbox" ng-change="showRemove()"
								ng-model="checkSelected"></td>
							<td>

								<div ng-show="checkSelected">
									<button type="button" ng-click="ctrl.remove(currentTask.id)"
										class="btn btn-danger custom-width">Remove</button>
								</div>
							</td>
							<td>
								<div>
									<button type="button" ng-click="ctrl.edit(currentTask.id)"
										class="btn btn-success custom-width">Edit</button>
								</div>

							</td>

						</tr>
					</tbody>
				</table>
			</div>
			<input class="btn btn-primary"
				value="{{!ctrl.task.id ? 'New Task' : 'Update Task'}}" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapseCreateTask"
				aria-expanded="false" aria-controls="collapseCreateTask">

		</div>

		<div class="collapse" id="collapseCreateTask">
			<div class="card card-body">
				<div class="panel panel-default">

					<div class="formcontainer">
						<form ng-submit="ctrl.submit()" name="taskForm"
							class="form-horizontal">
							<input type="hidden"  ng-model="ctrl.task.id" />
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="description">Description</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.task.description"
											id="description" class=" form-control input-sm"
											placeholder="Enter a task description" required
											 />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="date">Due
										Date</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.task.dueDate" id="date"
											class="form-control input-sm"
											placeholder="Enter a due date. " />
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="form-actions floatRight">
									<input type="submit"
										value="{{ctrl.task.id ? 'Update' : 'Add'}}"
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


	<tag:footer></tag:footer>
</body>
</html>