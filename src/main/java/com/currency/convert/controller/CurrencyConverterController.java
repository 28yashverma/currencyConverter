package com.currency.convert.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.convert.model.Currency;
import com.currency.convert.model.CurrencyExchange;
import com.currency.convert.model.CurrencyRates;
import com.currency.convert.model.Queries;
import com.currency.convert.model.builder.QueriesBuilder;
import com.currency.convert.service.QueriesService;

@RestController
@PropertySource("api.properties")
public class CurrencyConverterController {

	@Autowired
	private QueriesService queriesService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${apilatestRates}")
	private String latestExchangeRates;

	@Value("${apicurrencies}")
	private String apiGetCurrenciesList;

	@Value("${api.key}")
	private String apiKey;

	@Value("${apiCurrenciesConvert}")
	private String apiCurrencyConvert;

	private static final String _separator = "/";

	@GetMapping("/latest")
	@Cacheable(value = "latest")
	public List<CurrencyRates> getLatestRates(ModelMap modelMap) {
		CurrencyExchange exchange = restTemplate.getForEntity(latestExchangeRates, CurrencyExchange.class).getBody();
		List<CurrencyRates> currencyMap = new ArrayList<>();
		for (Entry<String, Double> m : exchange.getRates().entrySet()) {

			switch (m.getKey()) {
			case "EUR":
				currencyMap.add(new CurrencyRates(m.getKey(), BigDecimal.valueOf(m.getValue())));
				break;

			case "INR":
				currencyMap.add(new CurrencyRates(m.getKey(), BigDecimal.valueOf(m.getValue())));
				break;

			case "USD":
				currencyMap.add(new CurrencyRates(m.getKey(), BigDecimal.valueOf(m.getValue())));
				break;

			case "AUD":
				currencyMap.add(new CurrencyRates(m.getKey(), BigDecimal.valueOf(m.getValue())));
				break;

			case "JPY":
				currencyMap.add(new CurrencyRates(m.getKey(), BigDecimal.valueOf(m.getValue())));
				break;

			default:
				break;
			}

		}
		return currencyMap;
	}

	@GetMapping("/currencies")
	public List<String> currenciesList() {
		return Currency.getListOfCurrencies();
	}

	@GetMapping("/convert/{amount}/{fromCurrency}/{toCurrency}")
	public String convertedCurrency(@PathVariable String amount, @PathVariable String fromCurrency,
			@PathVariable String toCurrency) {
		String result = "";
		if (amount.isEmpty()) {
			throw new IllegalArgumentException("Amount cannot be empty");
		}

		if (fromCurrency.equalsIgnoreCase(toCurrency)) {
			throw new IllegalArgumentException("Same level currencies cannot be converted as they yield same values");
		}

		result = restTemplate.getForEntity(
				apiCurrencyConvert + amount + _separator + fromCurrency + _separator + toCurrency + "?app_id=" + apiKey,
				String.class).getBody();

		return result;
	}

	@GetMapping("/saveQueries")
	public void saveQueries(@RequestParam String username, @RequestParam Date date, @RequestParam String fromCurrency,
			@RequestParam String toCurrency, @RequestParam BigDecimal rate, @RequestParam String result) {
		Queries queries = new QueriesBuilder().setQueryUsername(username).setQueriedDate(date)
				.setFromCurrency(fromCurrency).setToCurrency(toCurrency).setRate(rate).setResult(result).build();
		queriesService.saveQuery(queries);
	}

	@GetMapping("/list/{username}")
	public List<Queries> listQueries(@PathVariable(name = "username") String username) throws Exception {
		if (username.isEmpty()) {
			throw new Exception("User name is empty");
		}
		return queriesService.listOfQueries(username);
	}

}
