package com.organization.OhIForgot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


	//shows welcome page
	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}
	
	
	
	

}
