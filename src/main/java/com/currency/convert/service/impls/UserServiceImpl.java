package com.currency.convert.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.currency.convert.model.User;
import com.currency.convert.repository.UserRepository;
import com.currency.convert.service.UserService;

/**
 * @author yeshendra service impl
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByemail(email);
	}

	@Override
	public User findUserByusername(String username) {
		return userRepository.findByusername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
