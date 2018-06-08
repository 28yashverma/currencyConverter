package com.currency.convert.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author yeshendra Entity class for Currency rates
 *
 */
@Entity
public class CurrencyRates {

	public CurrencyRates() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyRates(String name, BigDecimal rate) {
		this.currencyName = name;
		this.rate = rate;
	}

	@Id
	private String currencyName;
	private BigDecimal rate;

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "CurrencyRates [currencyName=" + currencyName + ", rate=" + rate + "]";
	}

}
