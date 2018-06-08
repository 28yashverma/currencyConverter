package com.currency.convert.service;

import com.currency.convert.model.User;

/**
 * @author yeshendra service
 *
 */
public interface UserService {

	public User findUserByEmail(String email);

	public User findUserByusername(String username);

	public void saveUser(User user);
}
