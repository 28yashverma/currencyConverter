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
import org.springframework.web.bind.annotation.PostMapping;

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

		if (bindingResult.hasErrors()) {
			modelMap.put("countryList", prepareCountryList());
		}

		if (userService.findUserByusername(user.getUsername()) == null) {

			userService.saveUser(user);
			modelMap.put("userSaveStatus", "Success in saving user information");
			modelMap.put("username", user.getUsername());
			modelMap.put("registrationForm", new User());
			modelMap.put("countryList", prepareCountryList());
		} else {
			modelMap.put("userSaveStatus", "User name already exists");
			modelMap.put("countryList", prepareCountryList());
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

}
