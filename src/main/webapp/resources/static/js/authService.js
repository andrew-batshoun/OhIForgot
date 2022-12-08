'use strict'

angular.module('taskApp').factory('UserService', ['$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8080/api/auth/';

	var factory = {	
		login: login,
		saveUser: saveUser,
		
	};

	return factory;
	
	//user login
	function login() {
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI + login).then(function(response) {
			deferred.resolve(response.data);
		},
			function(errResponse) {
				console.error('Error while fetching Tasks');
				deferred.reject(errResponse);
			});
		return deferred.promise;
	}

	
	//saves user
	function saveUser(user) {
		var deferred = $q.defer();
		console.log(user)
		$http.post(REST_SERVICE_URI+ "signup", user).then(function(response) {
			
			console.log('User Saved ');
			deferred.resolve(response.data);
			
		}, function(errorResponse){
			console.log("Error " + errorResponse )
		});
		return deferred.promise;
	}
	
	



}]);