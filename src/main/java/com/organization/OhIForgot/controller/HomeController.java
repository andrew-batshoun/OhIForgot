package com.organization.OhIForgot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.model.User;


@Controller
public class HomeController {


	//shows welcome page
	@GetMapping(value = "/")
	public String welcome() {
		return "welcome";
	}
	
	//shows task page 
	@GetMapping( "tasks")
	public String task() {
		return "tasksPage";
	}
	
	//shows login page
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	//shows register page
	@GetMapping("/signup")
	public String register() {
		return "register";
	}
	
//	@GetMapping("/profile")
//	public ModelAndView viewProfile( @RequestBody User user) {
//		return new ModelAndView("profile", "command", user);
//	}
	
	@GetMapping("/profile")
	public String viewProfile() {
		return "profile";
	}
	

}
