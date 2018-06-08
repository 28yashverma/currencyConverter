package com.currency.convert.service.impls;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.convert.model.Queries;
import com.currency.convert.model.builder.QueriesBuilder;
import com.currency.convert.repository.QueriesRepository;
import com.currency.convert.service.QueriesService;

/**
 * @author yeshendra ServiceImpl
 *
 */
@Service
public class QueriesServiceImpl implements QueriesService {

	@Autowired
	private QueriesRepository queriesRepository;

	@Override
	public void saveQuery(String username, Date queriedDate, String currencyFrom, String currencyTo, BigDecimal rate,
			String result, BigDecimal amount) {
		Queries q = new QueriesBuilder().setQueryUsername(username).setQueriedDate(queriedDate)
				.setFromCurrency(currencyFrom).setToCurrency(currencyTo).setRate(rate).setResult(result)
				.setAmount(amount).build();
		queriesRepository.save(q);
	}

	@Override
	public void saveQuery(Queries queries) {
		queriesRepository.save(queries);
	}

	@Override
	public List<Queries> listOfQueries(String username) {
		return queriesRepository.listQueries(username);
	}

}
