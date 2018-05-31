package com.currency.convert.service;

public interface SecurityService {

	public String loggedInUsername();

	void keepLoggedIn(String username, String password);

}
