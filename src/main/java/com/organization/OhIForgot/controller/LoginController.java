package com.organization.OhIForgot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.organization.OhIForgot.model.User;
import com.organization.OhIForgot.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> login(@RequestBody User user){
	List<User> existingUsers =	userService.findAllUsers();
	   for(User exist: existingUsers) {
		   if(exist.getId().equals(user.getId())) {
			   return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		   }else {
			   return new ResponseEntity<User>(HttpStatus.OK);
		   }
		   
	   }
	   return null; 
	
	}
	
	

}
