package com.currency.convert.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.currency.convert.enums.Country;
import com.currency.convert.model.User;

@Controller
public class RegistrationController {

	@GetMapping("/register")
	public String register(Map<String, Object> model) {
		User userForm = new User();
		model.put("registrationForm", userForm);

		List<Country> countryList = new ArrayList<>();
		countryList.add(Country.AUS);
		countryList.add(Country.GER);
		countryList.add(Country.IND);
		countryList.add(Country.JPA);
		countryList.add(Country.US);

		model.put("countryList", countryList);

		List<String> rolesList = new ArrayList<>();
		rolesList.add("USER");
		rolesList.add("ADMIN");
		rolesList.add("MANAGER");

		model.put("rolesList", rolesList);
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("registrationForm") User user, BindingResult bindingResult,
			ModelMap modelMap) {
		return "login";
	}

}
