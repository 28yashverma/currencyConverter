package com.currency.convert.service.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.convert.model.Role;
import com.currency.convert.model.User;
import com.currency.convert.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		User user = userRepository.findByusername(name);

		System.out.println("Retrieved user : " + user);
		
		List<SimpleGrantedAuthority> listOfAuthorities = new ArrayList<>();

		for (Role role : user.getRoles()) {
			listOfAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new org.springframework.security.core.userdetails.User(name, user.getPassword(), listOfAuthorities);

	}
}
