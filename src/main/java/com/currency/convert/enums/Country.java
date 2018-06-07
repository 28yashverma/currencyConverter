package com.currency.convert.enums;

public enum Country {

	INDIA("IND", "INDIA"), GERMANY("GER", "GERMANY"), AUSTRALIA("AUS", "AUSTRALIA"), USA("USA",
			"USA"), JAPAN("JPY",
			"JAPAN");

	private String countryCode;
	private String countryCodeDescription;

	Country(String countryCode, String countryCodeDescription) {
		this.countryCode = countryCode;
		this.countryCodeDescription = countryCodeDescription;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryCodeDescription() {
		return countryCodeDescription;
	}

}
