package com.currency.convert.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.convert.model.CurrencyRates;
import com.currency.convert.repository.CurrencyRatesRepository;
import com.currency.convert.service.CurrencyRatesService;

@Service
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

	@Autowired
	private CurrencyRatesRepository repo;

	@Override
	public void save(CurrencyRates rates) {
		repo.save(rates);
	}

	@Override
	public List<CurrencyRates> findAll() {
		return repo.findAll();
	}

}
