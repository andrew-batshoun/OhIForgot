package com.organization.OhIForgot.service;

import java.util.List;

import com.organization.OhIForgot.model.User;

public interface UserService {

	public User findById(Long id);
	public User findbyName(String username);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
	public List<User> findAllUsers();
	
	
}
