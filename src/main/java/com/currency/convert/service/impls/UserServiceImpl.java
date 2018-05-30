package com.currency.convert.service.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.currency.convert.model.Role;
import com.currency.convert.model.User;
import com.currency.convert.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		saveUser();
		User user = userRepository.findByusername(name);
		UserBuilder userBuilder = null;

		if (user != null) {
			userBuilder = org.springframework.security.core.userdetails.User.withUsername(name);
			userBuilder.password(user.getPassword());
		} else {
			throw new UsernameNotFoundException("User not found");
		}

		return userBuilder.build();

	}

	private void saveUser() {
		User u = new User();
		Set<Role> roles = new HashSet<>();
		Role r = new Role();
		r.setRole("USER");
		u.setUsername("yeshendra");
		u.setPassword(passwordEncoder.encode("password"));
		roles.add(r);
		u.setRoles(roles);

		userRepository.save(u);
	}

}
