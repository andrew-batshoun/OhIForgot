'use strict';
angular.module('taskApp').controller('ProductController', ['$scope', 'TaskService',function($scope, TaskService){
	var self = this;
	self.task = {id: '', description:'', startDate:'', endDate:'', isCompleted:false};
	self.tasks=[];
	
	self.listTasks = function(){
		TaskService.listTasks().this(function(data){
			self.tasks = data;
		});
	}
	
	self.saveTask = function(){
		TaskService.saveTask(self.task).then(function(){
			self.listTasks();
		});		
	}
	
	self.updateTask = function(){
		return TaskService.updateTask(self.task).then(function(){
			self.listTasks();
		});
	}
	
	self.selectTask = function(selectedTask){
		self.task = angular.copy(selectedTask);
	}
	
	self.reset = function(){
		self.task = {};
	}
	
	self.listTasks();
	
	
}]);