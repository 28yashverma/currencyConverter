package com.currency.convert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currency.convert.model.User;
import com.currency.convert.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

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

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/checkLoginUser/{username}", produces = "application/json")
	public String checkLoginUser(@PathVariable(name = "username") String username) {
		User user = userService.findUserByusername(username);

		if (user == null) {
			return "This user is not registered. Please register!";
		} else {
			return "Please enter your password";
		}
	}

}
