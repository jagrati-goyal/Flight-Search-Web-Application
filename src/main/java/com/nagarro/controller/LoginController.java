package com.nagarro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.model.User;
import com.nagarro.service.api.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	// preprocessor to trim whitespaces from string
	@InitBinder
	public void initBinder(WebDataBinder binder){
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmer);
	}
	
	// whenever client visits the website, this page will open.
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "login";
		}

		else if (loginService.isValidUser(user.getName(), user.getPassword())) {
			return "redirect:params";
		} else {
			model.addAttribute("invalidUser", true);
			return "login";
		}
	}
}
