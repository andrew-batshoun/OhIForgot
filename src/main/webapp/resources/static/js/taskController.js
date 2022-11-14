'use strict';
angular.module('taskApp').controller('TasksController', ['TaskService', function(TaskService) {
	var self = this;
	self.task = { id: '', description: '' };
	self.tasks = [];

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


	

}]);