'use strict'

angular.module('taskApp').factory('AuthService', ['$http', '$q', '$window', function($http, $q, $window) {


	var REST_SERVICE_URI = 'http://localhost:8080/api/auth/';

	var factory = {
		login: login,
		saveUser: saveUser

	};

	return factory;



	//login
	function login(user) {
		var deferred = $q.defer();
		var req = {
			method: "POST",
			url: REST_SERVICE_URI + "login",
			headers: {
				'Content-Type': 'application/json',
							},
			data: angular.toJson(user)
			
		}
		console.log(req);
		$http(req).then(function(response) {
			console.log(response.data);
			deferred.resolve(response.data);
		},
			function(errResponse) {
				console.error('Error while Loggin in');
				deferred.reject(errResponse);
			});
		return deferred.promise;
	}



	//saves user
	function saveUser(user) {
		var deferred = $q.defer();
		console.log(user);
		$http.post(REST_SERVICE_URI + "signup", user).then(function(response) {

			console.log('User Saved ');
			deferred.resolve(response.data);

		}, function(errorResponse) {
			console.log("Error " + errorResponse)
		});
		return deferred.promise;
	};





}]);