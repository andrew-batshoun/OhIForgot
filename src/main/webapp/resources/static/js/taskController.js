'use strict';
angular.module('taskApp').controller('TasksController', ['TaskService',function(TaskService){
	var self = this;
	self.task = {id: '', description:'', startDate:'', endDate:'', isCompleted:false};
	self.tasks=[];
	
	
	self.listTasks = function(){
		TaskService.listTasks().this(function(data){
			self.tasks = data;
		},
		function(errResponse){
			console.error(errResponse +':Error while fetching list');
		});
	}
	
	self.saveTask = function(task){
		TaskService.saveTask(task).then(listTasks, function(errResponse){
			console.error(errResponse +':Error while creating task');
		});		
	}
	
	self.updateTask = function(task, id){
		TaskService.updateTask(task, id).then(listTasks, function(errResponse){
			console.error(errResponse +':Error while fetching list');
		});
	}
	
	self.deleteTask = function(id){
		TaskService.deleteTask(id).then(listTasks, function(errResponse){
			console.error(errResponse +':Error while fetching list');
		});
	}
	
	self.selectTask = function(task){
				self.task = angular.copy(task); 
			}
	
	self.resetForm = function(){
			  self.task = {};

			}
	self.listTasks();
	
}]);