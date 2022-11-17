package com.organization.OhIForgot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.organization.OhIForgot.model.User;

@Controller
public class LoginController {

	//login validation 
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("user") User user) {

		if (user != null && user.getUsername() != null & user.getPassword() != null) {
			if (user.getUsername().equals("admin") && user.getPassword().equals("abc123")) {
				model.addAttribute("message", user.getUsername());
				return "redirect:/welcome";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "/login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "/login";
		}
	}

}
