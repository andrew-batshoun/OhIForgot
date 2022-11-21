package com.organization.OhIForgot.dao;

import java.util.List;

import com.organization.OhIForgot.model.User;

public interface UserDAO {
	public User findById(Long id);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
	public List<User> findAllUsers();
}
