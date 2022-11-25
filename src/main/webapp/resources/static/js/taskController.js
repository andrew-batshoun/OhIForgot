'use strict';
angular.module('taskApp').controller('TasksController', ['$scope', 'TaskService', function($scope, TaskService) {
	var self = this;
	self.task = { id: null, description: '', dueDate: '' };
	self.tasks = [];

	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	


	listTasks();

	function listTasks() {
		TaskService.listTasks().then(function(data) {
			self.tasks = data;
		},
			function(errResponse) {
				console.error(errResponse + ':Error while fetching list');
			});
	}

	function saveTask(task) {
		return TaskService.saveTask(task).then(listTasks, function(errResponse) {
			console.error(errResponse + ':Error while creating task');
		});
	}

	function updateTask(task, id) {
		TaskService.updateTask(task, id)
			.then(
				listTasks,
				function(errResponse) {
					console.error(errResponse + 'Error while updating Task');
				}
			);
	}

	function deleteTask(id) {
		TaskService.deleteTask(id)
			.then(
				listTasks,
				function(errResponse) {
					console.error(errResponse + 'Error while deleting Task');
				}
			);
	}

	function edit(id) {
		console.log('id to be edited', id);
		for (const element of self.tasks) {
			if (element.id === id) {
				self.task = angular.copy(element);
				break;
			}
		}
	}

	function remove(id) {
		console.log('id to be deleted', id);
		let accept = confirm("Do you want to delete task?");
		if (accept) {
			deleteTask(id);
		} else {
			reset();
		}

	}

	function submit() {

		saveTask(self.task);
		 
		//if(self.task.id !== null){
		//	updateTask(self.task, self.task.id);
		//	console.log('Task updated with id ', self.task.id);
		//}
		reset();
	}

	function reset() {
		self.task = { id: null, description: '', dueDate: null };
		$scope.taskForm.$setPristine();
	}

	$scope.showMe = false;

	$scope.showRemove = function() {
		$scope.showMe = $scope.checkSelected;
		console.log("checked task id:" + self.task.id)
	}

	$scope.getTemplate = function(task) {
		if (task.id === self.task.id) {
			return 'edit';
		}
		else return 'display'
	}

	$scope.updateSubmit = function() {
		console.log(self.task.description)
		updateTask(self.task, self.task.id);
		console.log(self.task.description);
		console.log('Task updated with id ', self.task.id);
		reset();
	};




}]);