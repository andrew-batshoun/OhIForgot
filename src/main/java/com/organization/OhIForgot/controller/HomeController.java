package com.organization.OhIForgot.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.Task;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping( method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/tasks", method = RequestMethod.GET)
	public ModelAndView tasks() {
		return new ModelAndView("tasksPage", "command", new Task());
	}
	
}
