package com.organization.OhIForgot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.User;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("message", "Please Enter your login");
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginPost(Model model, @ModelAttribute("user") User user) {

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
