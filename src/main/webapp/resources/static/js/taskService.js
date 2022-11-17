'use strict'

angular.module('taskApp').factory('TaskService', ['$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8081/tasks/';

	var factory = {
		listTasks: listTasks,
		saveTask: saveTask,
		updateTask: updateTask,
		deleteTask: deleteTask
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
			console.log('Task Saved ');
			deferred.resolve(response.data);
			
		}, function(errorResponse){
			console.log(errorResponse + "Error")
		});
		return deferred.promise;
	}
	
	function updateTask(task, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, task)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating task');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function deleteTask(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Task');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }



}]);