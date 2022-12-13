'use strict';
angular.module('taskApp').controller('AuthController', ['$scope', '$window', 'AuthService', function($scope, $window, AuthService) {
	var self = this;
	self.user = { id: null, email: '', username: '', password: '' };
	self.users = [];

	self.loginSubmit = loginSubmit;
	self.submit = submit;
	self.reset = reset;

	//login function 
	function login(user) {

		return AuthService.login(user).then(function(data) {
			console.log(data);
			if (user.username === data.username) {
				toTasks();
			} else {
				redirect();
			}

		}, function(errResponse) {
			console.error(errResponse + 'Error logging in');

		}
		);

	}

	//calls login function
	function loginSubmit() {
		let userLog = {
			username: $scope.username,
			password: $scope.password
		}
		console.log(userLog);
		login(userLog);
	}





	//function to save user
	function saveUser(user) {
		return AuthService.saveUser(user).then(redirect, function(errResponse) {
			console.log(errResponse + ':Error while creating user');

		});
	}

	//calls saveuser function when form is submitted
	function submit() {
		saveUser(self.user);
	}



	//resets form
	function reset() {
		self.user = { id: null, email: '', username: '', password: '' };
		$scope.taskForm.$setPristine();
	}

	//function to redirect to login, called in saveuser
	function redirect() {
		var url = "/login";
		$window.location.href = url;
	}

	//function to redirect to login, called in saveuser
	function toTasks() {
		var url = "/tasks";
		$window.location.href = url;
	}


	
	
		
		
	

	





}]);