package com.organization.OhIForgot.controller;



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
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public String loginPost(Model model, @ModelAttribute("user") User user) {
		User existingUser = userService.findbyName(user.getUsername());
			
		if (existingUser != null && user.getUsername() != null & user.getPassword() != null) {
			if (user.getUsername().equals(existingUser.getUsername()) && user.getPassword().equals(existingUser.getPassword())) {
				model.addAttribute("message", user.getUsername());
				return "redirect:/tasks";
			} else {
				model.addAttribute("error", "Invalid Login Details");
				return "/login";
			}
		} else {
			model.addAttribute("error", "Please enter Login Details");
			return "/login";
		}
		}
		
	}
	
	


