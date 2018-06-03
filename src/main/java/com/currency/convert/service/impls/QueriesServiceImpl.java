package com.currency.convert.service.impls;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.convert.model.Queries;
import com.currency.convert.repository.QueriesRepository;
import com.currency.convert.service.QueriesService;

@Service
public class QueriesServiceImpl implements QueriesService {

	@Autowired
	private QueriesRepository queriesRepository;

	@Override
	public void saveQuery(String username, Date queriedDate, String currencyFrom, String currencyTo, BigDecimal rate,
			String result) {
		Queries query = new Queries();
		query.setQueryUsername(username);
		query.setQueriedDate(queriedDate);
		query.setFromCurrency(currencyFrom);
		query.setToCurrency(currencyTo);
		query.setRate(rate);
		queriesRepository.save(query);
	}

	@Override
	public void saveQuery(Queries queries) {
		queriesRepository.save(queries);
	}

}
