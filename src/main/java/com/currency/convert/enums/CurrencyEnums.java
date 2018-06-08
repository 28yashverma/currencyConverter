package com.currency.convert.enums;

/**
 * 
 * @author yeshendra enum constants
 *
 */
public enum CurrencyEnums {
	EUR("EUR"), INR("INR"), USD("USD"), AUD("AUD"), JPA("JPY");

	String description;

	CurrencyEnums(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
