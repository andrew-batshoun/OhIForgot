'use strict'

angular.module('taskApp').factory('TaskService', ['$http', function($http){
	var REST_SERVICE_URI = '/task';
	var factory = {
		listTasks: listTasks,
		saveTask: saveTask,
		updateTask: updateTask,
		deleteTask: deleteTask
	};
	return factory;
	function listTasks(){
		return $http.get(REST_SERVICE_URI).then(function(response){
			return response.data;
		});
	}
	
	function saveTask(task){
		return $http.post(REST_SERVICE_URI).then(function(response){
			return response.data;
		});
	}
	function updateTask(task){
		return $http.put(REST_SERVICE_URI).then(function(response){
			return response.data; 
		});
	}
	function deleteTask(taskId){
		return $http.delete(REST_SERVICE_URI + taskId).then(function(response){
			if(response.data){
				$log.info("Successfully Deleted task id: " + taskId)
			} else{
				$log.debug("No Game Deleted with id: " + taskId)
			}
			return response.data;
		});
	}
	
}])