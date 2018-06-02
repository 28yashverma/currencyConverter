package com.currency.convert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.currency.convert.model.Currency;
import com.currency.convert.model.CurrencyExchange;

@Controller
@PropertySource("api.properties")
public class CurrencyConverterController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${apilatestRates}")
	private String latestExchangeRates;

	@Value("${apicurrencies}")
	private String apiGetCurrenciesList;

	@ResponseBody
	@GetMapping("/latest")
	public CurrencyExchange getLatestRates(ModelMap modelMap) {
		return restTemplate.getForEntity(latestExchangeRates, CurrencyExchange.class).getBody();
	}

	@ResponseBody
	@GetMapping("/currencies")
	public List<String> currenciesList() {
		return Currency.getListOfCurrencies();
	}

	@ResponseBody
	@GetMapping("/convert/{amount}/{fromCurrency}/{toCurrency}")
	public String convertedCurrency(@PathVariable String amount, @PathVariable String fromCurrency,
			@PathVariable String toCurrency) {
		String result = "";
		System.out.println(amount);
		System.out.println(fromCurrency);
		System.out.println(toCurrency);

		if (result.isEmpty()) {
			throw new IllegalArgumentException("Amount cannot be empty");
		}

		if (fromCurrency.equalsIgnoreCase(toCurrency)) {
			throw new IllegalArgumentException("Same level currencies cannot be converted as they yield same values");
		}

		return result;
	}

}
