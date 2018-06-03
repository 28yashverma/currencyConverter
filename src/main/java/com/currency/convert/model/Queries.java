package com.currency.convert.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Queries {

	public Queries() {

	}

	public Queries(String username, Date date, String fromCurrency, String toCurrency, BigDecimal rate, String result) {
		this.queryUsername = username;
		this.queriedDate = date;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rate = rate;
		this.result = result;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long queryId;

	private String queryUsername;

	private Date queriedDate;

	private String fromCurrency;

	private String toCurrency;

	private BigDecimal rate;

	private String result;

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public Date getQueriedDate() {
		return queriedDate;
	}

	public void setQueriedDate(Date queriedDate) {
		this.queriedDate = queriedDate;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getQueryUsername() {
		return queryUsername;
	}

	public void setQueryUsername(String queryUsername) {
		this.queryUsername = queryUsername;
	}

	@Override
	public String toString() {
		return "Queries [queryId=" + queryId + ", queriedDate=" + queriedDate + ", fromCurrency=" + fromCurrency
				+ ", toCurrency=" + toCurrency + ", rate=" + rate + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
