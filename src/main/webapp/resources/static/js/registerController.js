'use strict';
angular.module('taskApp').controller('RegisterController', ['$scope', '$window', 'UserService', function($scope, $window, UserService) {
	var self = this;
	self.user = { id: null, email: '', username: '', password: '' };
	self.users = [];

	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	


	function saveUser(user) {
		return UserService.saveUser(user).then(redirect, function(errResponse) {
			console.log(errResponse + ':Error while creating user');
			
		});
	}

	function updateUser(user, id) {
		UserService.updateUser(user, id)
			.then(
				function(errResponse) {
					console.error(errResponse + 'Error while updating user');
				}
			);
	}

	function deleteUser(id) {
		UserService.deleteTask(id)
			.then(
			
			function(errResponse) {
				console.error(errResponse + 'Error while deleting user');
				}
			);
	}

	function edit(id) {
		console.log('id to be edited', id);
		for (const element of self.users) {
			if (element.id === id) {
				self.user = angular.copy(element);
				break;
			}
		}
	}

	function remove(id) {
		console.log('id to be deleted', id);
		let accept = confirm("Do you want to delete user?");
		if (accept) {
			deleteUser(id);
		} else {
			reset();
		}

	}

	function submit() {

		saveUser(self.user);
		 
	
	}

	function reset() {
		self.user = {  id: null, email: '', username: '', password: '' };
		$scope.taskForm.$setPristine();
	}
	
	function redirect(){
		var url = "/";
		$window.location.href = url;
	}
	






}]);