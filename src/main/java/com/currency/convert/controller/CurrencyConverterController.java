package com.currency.convert.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.convert.model.Currency;
import com.currency.convert.model.CurrencyExchange;
import com.currency.convert.model.CurrencyRates;
import com.currency.convert.model.Queries;
import com.currency.convert.service.CurrencyRatesService;
import com.currency.convert.service.QueriesService;

/**
 * 
 * @author yeshendra Currency exchange api controller
 *
 */
@RestController
@PropertySource("api.properties")
public class CurrencyConverterController {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);

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

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/latest")
	@Cacheable(value = "latest")
	public List<CurrencyRates> getLatestRates(ModelMap modelMap) {
		logger.info("Getting the latest currency rates");
		List<CurrencyRates> currencyMap = new ArrayList<>();
		CurrencyExchange exchange = restTemplate.getForEntity(latestExchangeRates, CurrencyExchange.class).getBody();
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

			for (CurrencyRates rates : currencyMap) {
				logger.info("Saving latest currency rates");
				currencyRatesService.save(rates);
			}

		}
		return currencyRatesService.findAll();
	}

	@GetMapping("/currencies")
	public List<String> currenciesList() {
		logger.info("Getting the list of currencies");
		return Currency.getListOfCurrencies();
	}

	@GetMapping("/convert/{amount}/{fromCurrency}/{toCurrency}")
	public BigDecimal convertedCurrency(Principal principal, @PathVariable String amount,
			@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		logger.info("Convert from " + fromCurrency + " to " + toCurrency);
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
		logger.info("Converted amount is : " + result);
		queriesService.saveQuery(principal.getName(), new Date(), fromCurrency, toCurrency, currencyRate,
				result.toPlainString(), localAmount);

		return result;
	}

	@GetMapping("/list")
	public List<Queries> listQueries(Principal principal) throws Exception {
		logger.info("Getting the history of queries made by user");
		String username = principal.getName();
		if (username.isEmpty()) {
			throw new Exception("User name is empty");
		}
		return queriesService.listOfQueries(username);
	}

}
