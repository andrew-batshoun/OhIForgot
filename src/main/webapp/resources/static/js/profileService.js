'use strict'

angular.module('taskApp').factory('ProfileService', ['$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8080/api/profile';

	var factory = {	
		getUser: getUser,
		updateUser: updateUser,
		deleteUser: deleteUser
		
	};

	return factory;

	//gets user by id
	
	function getUser(user, id){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI+id, user).then(
			function(response){
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.error('Error while retrieving user');
				deferred.reject(errResponse);
			}
		);
		return deferred.promise; 
	}
	
	
	//updates user
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
    
    //deletes user
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