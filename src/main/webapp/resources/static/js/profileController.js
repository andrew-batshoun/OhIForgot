'use strict';
angular.module('taskApp').controller('AuthorizeController', ['$scope', '$window', 'UserService', function($scope, $window, UserService) {
	var self = this;
	self.user = { id: null, email: '', username: '', password: '' };
	self.users = [];

	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
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
	
	//function to update user NOT APPLIED	
	function updateUser(user, id) {
		UserService.updateUser(user, id)
			.then(
				function(errResponse) {
					console.error(errResponse + 'Error while updating user');
				}
			);
	}
	
	//function to select user to be updated
	function edit(id) {
		console.log('id to be edited', id);
		for (const element of self.users) {
			if (element.id === id) {
				self.user = angular.copy(element);
				break;
			}
		}
	}
	
	//function to delete user NOT APPLIED	
	function deleteUser(id) {
		UserService.deleteTask(id)
			.then(
			
			function(errResponse) {
				console.error(errResponse + 'Error while deleting user');
				}
			);
	}
	
	//calls deleteuser function 
	function remove(id) {
		console.log('id to be deleted', id);
		let accept = confirm("Do you want to delete user?");
		if (accept) {
			deleteUser(id);
		} else {
			reset();
		}

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