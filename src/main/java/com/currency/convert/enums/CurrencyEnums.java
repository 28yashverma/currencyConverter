package com.currency.convert.enums;

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
