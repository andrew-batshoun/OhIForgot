'use strict'

angular.module('taskApp').factory('TaskService', ['$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8081/tasks/';

	var factory = {
		listTasks: listTasks,
		saveTask: saveTask
	};

	return factory;

	function listTasks() {
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI + "tasklist").then(function(response) {
			deferred.resolve(response.data);
		},
			function(errResponse) {
				console.error('Error while fetching Tasks');
				deferred.reject(errResponse);
			});
		return deferred.promise;
	}

	function saveTask(task) {
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI, task).then(function(response) {
			console.log('Error creating task');
			deferred.resolve(response.data);
			
		});
		return deferred.promise;
	}



}]);