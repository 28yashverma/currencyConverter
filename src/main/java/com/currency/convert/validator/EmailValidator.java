package com.currency.convert.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yeshendra validator for email
 *
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext ctx) {

		if (email == null || email.isEmpty()) {
			return false;
		}

		if (email.matches("[A-Za-z0-9._%+-]+@[A-Za-z]+.[A-Za-z]{2,6}$")) {
			return true;
		}

		return false;
	}

	@Override
	public void initialize(Email constraintAnnotation) {
	}

}
