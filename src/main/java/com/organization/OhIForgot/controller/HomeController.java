package com.organization.OhIForgot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
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
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET )
	public ModelAndView task() {
		return new ModelAndView("tasksPage", "command", new Task());
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register", "command", new User());
	}
	

}
