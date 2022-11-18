package com.organization.OhIForgot.service;

import java.util.List;

import com.organization.OhIForgot.model.User;

public interface UserService {

	User findById(Long id);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUser(Long id);
	List findAllUsers();
	
	
}
