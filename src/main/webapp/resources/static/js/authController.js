'use strict';
angular.module('taskApp').controller('AuthController', ['$scope', '$window', '$location', 'AuthService', function($scope, $window, $location, AuthService,  ) {
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
			toTasks();
			

		}, function(errResponse) {
			console.error(errResponse + 'Error logging in');
			redirect();
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
		
		return AuthService.saveUser(user).then(function(data) {
			console.log(data);
			redirect(); 
			

		}, function(errResponse) {
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
		var url = "http://localhost:8081/login";
		$window.location.href = url;
	}

	//function to redirect to login, called in saveuser
	function toTasks() {
		var url = "http://localhost:8081/tasks";
		$window.location.href = url;
	}


	
	
		
		
	

	





}]);