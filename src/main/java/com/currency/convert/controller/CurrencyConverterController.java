package com.currency.convert.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.convert.model.Currency;
import com.currency.convert.model.CurrencyRates;
import com.currency.convert.model.Queries;
import com.currency.convert.service.CurrencyRatesService;
import com.currency.convert.service.QueriesService;

@RestController
@PropertySource("api.properties")
public class CurrencyConverterController {

	@Autowired
	private QueriesService queriesService;

	@Autowired
	private CurrencyRatesService currencyRatesService;

	@Value("${apilatestRates}")
	private String latestExchangeRates;

	@Value("${apicurrencies}")
	private String apiGetCurrenciesList;

	@Value("${api.key}")
	private String apiKey;

	@Value("${apiCurrenciesConvert}")
	private String apiCurrencyConvert;

	private List<CurrencyRates> rates = null;

	@GetMapping("/latest")
	@Cacheable(value = "latest")
	public List<CurrencyRates> getLatestRates(ModelMap modelMap) {
		return currencyRatesService.findAll();
	}

	@GetMapping("/currencies")
	public List<String> currenciesList() {
		return Currency.getListOfCurrencies();
	}

	@GetMapping("/convert/{amount}/{fromCurrency}/{toCurrency}")
	public BigDecimal convertedCurrency(Principal principal, @PathVariable String amount,
			@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		rates = currencyRatesService.findAll();
		BigDecimal result = BigDecimal.ZERO;
		BigDecimal currencyRate = BigDecimal.ZERO;
		BigDecimal localAmount = new BigDecimal(amount);
		Map<String, BigDecimal> mapRates = new HashMap<>();

		if (amount.isEmpty()) {
			throw new IllegalArgumentException("Amount cannot be empty");
		}

		if (fromCurrency.equalsIgnoreCase(toCurrency)) {
			throw new IllegalArgumentException("Same level currencies cannot be converted as they yield same values");
		}

		if (result.intValue() == 0) {
			for (CurrencyRates rate : rates) {
				mapRates.put(rate.getCurrencyName(), rate.getRate());
			}
		}
		currencyRate = mapRates.get(toCurrency).divide(mapRates.get(fromCurrency), 3, RoundingMode.FLOOR);
		result = localAmount.multiply(currencyRate);

		queriesService.saveQuery(principal.getName(), new Date(), fromCurrency, toCurrency, currencyRate,
				result.toPlainString(), localAmount);

		return result;
	}

	@GetMapping("/list")
	public List<Queries> listQueries(Principal principal) throws Exception {
		String username = principal.getName();
		if (username.isEmpty()) {
			throw new Exception("User name is empty");
		}
		return queriesService.listOfQueries(username);
	}

}
