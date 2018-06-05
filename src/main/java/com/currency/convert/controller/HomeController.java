package com.currency.convert.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.currency.convert.model.CurrencyExchange;
import com.currency.convert.model.CurrencyRates;
import com.currency.convert.service.CurrencyRatesService;

@Controller
@PropertySource("api.properties")
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	private List<CurrencyRates> currencyMap = null;

	@Autowired
	private CurrencyRatesService currencyRatesService;

	@Value("${apilatestRates}")
	private String latestExchangeRates;

	@GetMapping("/hello")
	public String hello(Principal principal, ModelMap model) {
		String username = "";
		if (principal != null) {
			username = principal.getName();
			model.addAttribute("username", username);
		}
		return "hello";
	}

	@GetMapping("/loadData")
	@ResponseBody
	public void loadData() {
		currencyMap = new ArrayList<>();
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

		}
		for (CurrencyRates rates : currencyMap) {
			currencyRatesService.save(rates);
		}
	}

}
