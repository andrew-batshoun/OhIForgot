package com.organization.OhIForgot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.OhIForgot.dao.UserDAO;
import com.organization.OhIForgot.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO; 
	
	@Override
	@Transactional
	public User findById(Long id) {
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		userDAO.deleteUser(id);
		
	}

	@Override
	@Transactional
	public List findAllUsers() {
		
		return userDAO.findAllUsers();
	}

	

}
