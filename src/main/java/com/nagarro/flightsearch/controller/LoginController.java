package com.nagarro.flightsearch.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.nagarro.flightsearch.constants.SpringConstants;
import com.nagarro.flightsearch.model.User;
import com.nagarro.flightsearch.service.api.LoginService;

/**
 * The class {@link LoginController} is a spring controller.<br>
 * This class is responsible for handling all the requests related to login.
 * <br>
 * The user should not create the instance of this class as the Spring container
 * automatically registers this class as bean in the application context.
 * 
 * @author jagratigoyal
 */
@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private LoginService loginService;

	// injects the loginService at run time
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	// preprocessor to trim whitespaces from string
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmer);
	}

	/**
	 * this method handles request for login page
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(SpringConstants.REQUEST_DEFAULT_PAGE)
	public String homePage(Model model) {
		model.addAttribute(SpringConstants.MODEL_USER, new User());
		return SpringConstants.VIEW_LOGIN;
	}

	/**
	 * this method authenticates the login credentials entered by the user
	 * 
	 * @param user
	 *            - the {@link User} object
	 * @param result
	 *            - the {@link BindingResult} object <br>
	 *            &nbsp; &nbsp; used to store validation errors
	 * @param model
	 *            - the {@link Model} object
	 * @return
	 */
	@PostMapping(value = SpringConstants.REQUEST_LOGIN)
	public String login(@Valid @ModelAttribute(SpringConstants.MODEL_USER) User user, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return SpringConstants.VIEW_LOGIN;
		}

		else if (loginService.isValidUser(user.getName(), user.getPassword())) {
			return SpringConstants.REDIRECT_SEARCH_FLIGHT;
		} else {
			model.addAttribute(SpringConstants.MODEL_INVALID_USER, true);
			return SpringConstants.VIEW_LOGIN;
		}
	}

	/**
	 * this method methods logout request
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(SpringConstants.REQUEST_LOGOUT)
	public String logout(SessionStatus status) {
		status.setComplete();
		return SpringConstants.REDIRECT_DEFAULT_PAGE;
	}
}
