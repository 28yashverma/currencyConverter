package com.currency.convert.enums;

public enum Country {

	IND("IND", "INDIA"), GER("GER", "GERMANY"), AUS("AUS", "AUSTRALIA"), US("USA", "UNITED STATES"), JPY("JPY",
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
