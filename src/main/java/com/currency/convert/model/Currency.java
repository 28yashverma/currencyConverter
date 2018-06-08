package com.currency.convert.model;

/**
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Currency {

	// EUR, INR, USD, AUD, JPA
	public Currency() {

	}

	private static List<String> listOfCurrencies;

	public static List<String> getListOfCurrencies() {
		return listOfCurrencies;
	}

	static {
		listOfCurrencies = new ArrayList<>();
		listOfCurrencies.add("EUR");
		listOfCurrencies.add("INR");
		listOfCurrencies.add("USD");
		listOfCurrencies.add("AUD");
		listOfCurrencies.add("JPY");
	}
}
