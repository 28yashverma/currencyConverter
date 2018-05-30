package com.currency.convert.service;

import com.currency.convert.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public void saveUser(User user);
}
