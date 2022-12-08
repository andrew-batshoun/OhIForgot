'use strict';
angular.module('taskApp').controller('TasksController', ['$scope', 'TaskService', function($scope, TaskService) {
	var self = this;
	self.task = { id: null, description: '', dueDate: '' };
	self.tasks = [];

	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	

	//calls function for all tasks
	listTasks();

	//function for listing all tasks
	function listTasks() {
		TaskService.listTasks().then(function(data) {
			self.tasks = data;
		},
			function(errResponse) {
				console.error(errResponse + ':Error while fetching list');
			});
	}
	
	//function for saving a task 
	function saveTask(task) {
		return TaskService.saveTask(task).then(listTasks, function(errResponse) {
			console.error(errResponse + ':Error while creating task');
		});
	}
	
	//calls save function when form is submitted
	function submit() {

		saveTask(self.task);
		 
		reset();
	}
	
	//function for updating task 
	function updateTask(task, id) {
		TaskService.updateTask(task, id)
			.then(
				listTasks,
				function(errResponse) {
					console.error(errResponse + 'Error while updating Task');
				}
			);
	}
	
	//function to select task to edit
	function edit(id) {
		console.log('id to be edited', id);
		for (const element of self.tasks) {
			if (element.id === id) {
				self.task = angular.copy(element);
				$scope.ctrl.task.dueDate = new Date(self.task.dueDate);
				break;
			}
		}
	}
	
	//function to call update function when button is clicked
	$scope.updateSubmit = function() {
		console.log(self.task.description)
		updateTask(self.task, self.task.id);
		console.log(self.task.description);
		console.log('Task updated with id ', self.task.id);
		reset();
	};
	
	//if edit button is click returns script edit else returns list of task 
	$scope.getTemplate = function(task) {
		if (task.id === self.task.id) {
			return 'edit';
		}
		else return 'display'
	}
	
	//function for deleting task
	function deleteTask(id) {
		TaskService.deleteTask(id)
			.then(
				listTasks,
				function(errResponse) {
					console.error(errResponse + 'Error while deleting Task');
				}
			);
	}
	
	//function to call delete function when button is pressed
	function remove(id) {
		console.log('id to be deleted', id);
		let accept = confirm("Do you want to delete task?");
		if (accept) {
			deleteTask(id);
		} else {
			reset();
		}

	}
	
	//sets attribute to false
	$scope.showMe = false;

	//if checkbox is selected, sets showme to true and makes delete button appear
	$scope.showRemove = function() {
		$scope.showMe = $scope.checkSelected;
		console.log("checked task id:" + self.task.id)
	}

	//resets form on adding task 
	function reset() {
		self.task = { id: null, description: '', dueDate: null };
		$scope.taskForm.$setPristine();
	}

	
	

	

	




}]);