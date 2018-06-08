package com.currency.convert.service;

import java.util.List;

import com.currency.convert.model.CurrencyRates;


/**
 * @author yeshendra service 
 *
 */
public interface CurrencyRatesService {

	void save(CurrencyRates rates);

	List<CurrencyRates> findAll();

}
