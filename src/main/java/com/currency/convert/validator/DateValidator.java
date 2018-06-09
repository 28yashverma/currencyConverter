package com.currency.convert.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateValidator implements ConstraintValidator<BDate, Date> {
	private static final Logger logger = LoggerFactory.getLogger(DateValidator.class);

	@Override
	public boolean isValid(Date date, ConstraintValidatorContext ctx) {
		// min="1960-03-31" max="2000-03-31"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date minDate = null;
		Date maxDate = null;
		try {
			minDate = sdf.parse("1960-03-31");
			maxDate = sdf.parse("2000-03-31");
		} catch (ParseException e) {
			logger.error(e.getLocalizedMessage());
			return false;
		}

		if (date == null || date.compareTo(minDate) < 0 || date.compareTo(maxDate) > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void initialize(BDate constraintAnnotation) {
	}

}
