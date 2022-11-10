package com.organization.OhIForgot.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.Task;

@Controller
public class HomeController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
}
