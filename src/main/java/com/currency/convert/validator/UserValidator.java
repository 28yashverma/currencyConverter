package com.currency.convert.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.currency.convert.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.reject("confirmPassword", "password mismatched");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.password");
	}

}
