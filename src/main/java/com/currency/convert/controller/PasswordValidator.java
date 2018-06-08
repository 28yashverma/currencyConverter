package com.currency.convert.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.currency.convert.model.PasswordValidatorBean;

@RestController
public class PasswordValidator {

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	private Pattern pattern;
	private Matcher matcher;

	@PostMapping("/passwordValidate")
	public List<String> validatePassword(@RequestBody PasswordValidatorBean passwordValidatorBean) {

		List<String> errors = new ArrayList<>();

		if (!passwordValidatorBean.getPassword().equals(passwordValidatorBean.getConfirmPassword())) {
			errors.add("Password doesnot match");
		}

		if (passwordValidatorBean.getPassword().length() < 8) {
			errors.add("Password cannot be less than 8 characters");
		}

		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(passwordValidatorBean.getPassword());

		if (!matcher.matches()) {
			errors.add("Password did not match specified pattern, " + "must contain one digit from 0-9, "
					+ "must contain one lower case character, " + "must contain one upper case character, "
					+ "must contain 1 special symbols in the list '@#$%', "
					+ "length atleast 8 character and maximum 20 characters");
		}

		return errors;
	}

}
