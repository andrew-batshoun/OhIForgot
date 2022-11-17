package com.organization.OhIForgot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.model.User;

@Controller
public class HomeController {

	//shows login page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("message", "Please Enter your login");
		return "login";
	}
	
	//shows welcome page
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}
	
	//shows tasks page
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public ModelAndView task() {
		return new ModelAndView("tasksPage", "command", new Task());
	}
	
	

}
