package com.currency.convert.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PostMapping("/hello")
	public String hello(Principal principal, Model model) {
		String username = "";
		model.addAttribute("username", username);
		return "hello";
	}

}
