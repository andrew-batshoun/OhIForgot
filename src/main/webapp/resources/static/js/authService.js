'use strict'

angular.module('taskApp').factory('UserService', ['$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8080/api/register/';

	var factory = {	
		saveUser: saveUser,
		
	};

	return factory;

	
	//saves user
	function saveUser(user) {
		var deferred = $q.defer();
		console.log(user)
		$http.post(REST_SERVICE_URI, user).then(function(response) {
			
			console.log('User Saved ');
			deferred.resolve(response.data);
			
		}, function(errorResponse){
			console.log("Error " + errorResponse )
		});
		return deferred.promise;
	}
	
	//updates user. NOT APPLIED YET
	function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating user');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    //deletes user, NOT APPLIED YET
    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }



}]);