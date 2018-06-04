package com.currency.convert.service;

import java.util.List;

import com.currency.convert.model.CurrencyRates;

public interface CurrencyRatesService {

	void save(CurrencyRates rates);

	List<CurrencyRates> findAll();

}
