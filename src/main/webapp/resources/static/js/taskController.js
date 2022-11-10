'use strict';
angular.module('taskApp').controller('TasksController', ['TaskService',function(TaskService){
	var self = this;
	self.task = {id: '', description:''};
	self.tasks=[];
	
	
	self.listTasks = function(){
		TaskService.listTasks().then(function(data){
			self.tasks = data;
		},
		function(errResponse){
			console.error(errResponse +':Error while fetching list');
		});
	}
	
	self.saveTask = function(task){
		return TaskService.saveTask(task).then(listTasks, function(errResponse){
			console.error(errResponse +':Error while creating task');
			self.listTasks();
		});		
	}
	

	self.listTasks();
	
}]);