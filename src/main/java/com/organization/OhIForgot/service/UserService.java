package com.organization.OhIForgot.service;

import com.organization.OhIForgot.model.User;

public interface UserService {
  
	User findUserById(long id);
	User findUserByName(String name);
	Long saveUser(User user);
	void updateUser(User user);
	void deleteUser(long id);
}
