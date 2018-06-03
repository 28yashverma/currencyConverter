package com.currency.convert.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currency.convert.enums.Country;
import com.currency.convert.model.Role;
import com.currency.convert.model.User;
import com.currency.convert.service.UserService;
import com.currency.convert.validator.UserValidator;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/register")
	public String register(Map<String, Object> model) {
		User userForm = new User();
		model.put("registrationForm", userForm);

		model.put("countryList", prepareCountryList());

		return "register";
	}

	@PostMapping("/register")
	@Transactional
	public String register(@Valid @ModelAttribute("registrationForm") User user, BindingResult bindingResult,
			ModelMap modelMap) {

		Set<Role> roles = new HashSet<>();
		roles.add(new Role("USER"));
		roles.add(new Role("ADMIN"));
		user.setRoles(roles);

		userValidator.validate(user, bindingResult);
		modelMap.put("countryList", prepareCountryList());

		if (bindingResult.hasErrors()) {
			return "register";
		}

		if (userService.findUserByusername(user.getUsername()) == null) {

			userService.saveUser(user);
			modelMap.put("userSaveStatus", "Success in saving user information");
			modelMap.put("username", user.getUsername());
			modelMap.put("registrationForm", new User());
		} else {
			modelMap.put("userSaveStatus", "User name already exists");
		}

		return "register";
	}

	private static List<Country> prepareCountryList() {
		List<Country> countryList = new ArrayList<>();
		countryList.add(Country.AUS);
		countryList.add(Country.GER);
		countryList.add(Country.IND);
		countryList.add(Country.JPA);
		countryList.add(Country.US);
		return countryList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/checkUser/{username}", produces = "application/json")
	@ResponseBody
	public String checkUsernamePresence(@PathVariable(value = "username", required = true) String username) {

		if (username.length() < 0) {
			return "user name is empty";
		}

		User u = userService.findUserByusername(username);

		if (u != null) {
			return "user name is already registered";
		} else {
			return "user name is available";
		}
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/checkEmail/{email}", produces = "application/json")
	public String validateEmail(@PathVariable(value = "email") String email) {
		String result = "";
		User u = userService.findUserByEmail(email);
		if (u != null) {
			result = "Email already in use";
		}
		return result;
	}

}
