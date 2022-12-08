'use strict';
angular.module('taskApp').controller('AuthorizeController', ['$scope', '$window', 'UserService', function($scope, $window, UserService) {
	var self = this;
	self.user = { id: null, email: '', username: '', password: '' };
	self.users = [];

	self.submit = submit;
	
	self.reset = reset;
	

	//function to save user
	function saveUser(user) {
		return UserService.saveUser(user).then(redirect, function(errResponse) {
			console.log(errResponse + ':Error while creating user');
			
		});
	}
	
	//calls saveuser function when form is submitted
	function submit() {
		saveUser(self.user); 
	}
	
	

	//resets form
	function reset() {
		self.user = {  id: null, email: '', username: '', password: '' };
		$scope.taskForm.$setPristine();
	}
	
	//function to redirect to login, called in saveuser
	function redirect(){
		var url = "/login";
		$window.location.href = url;
	}
	






}]);