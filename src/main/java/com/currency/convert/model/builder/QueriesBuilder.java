package com.currency.convert.model.builder;

/**
 * Builder pattern for Queries Class
 */
import java.math.BigDecimal;
import java.util.Date;

import com.currency.convert.model.Queries;

public class QueriesBuilder {

	private String queryUsername;

	private Date queriedDate;

	private String fromCurrency;

	private String toCurrency;

	private BigDecimal rate;

	private String result;

	private BigDecimal amount;

	public QueriesBuilder setQueryUsername(String queryUsername) {
		this.queryUsername = queryUsername;
		return this;
	}

	public QueriesBuilder setQueriedDate(Date queriedDate) {
		this.queriedDate = queriedDate;
		return this;
	}

	public QueriesBuilder setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
		return this;
	}

	public QueriesBuilder setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
		return this;
	}

	public QueriesBuilder setRate(BigDecimal rate) {
		this.rate = rate;
		return this;
	}

	public QueriesBuilder setResult(String result) {
		this.result = result;
		return this;
	}

	public QueriesBuilder setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Queries build() {
		return new Queries(queryUsername, queriedDate, fromCurrency, toCurrency, rate, result, amount);
	}

}
