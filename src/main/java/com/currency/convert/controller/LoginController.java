package com.currency.convert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errorMsg", "Username or password are invalid");
		}

		if (logout != null) {
			model.addAttribute("msg", "Logged out successfully");
		}

		return "login";
	}

}
