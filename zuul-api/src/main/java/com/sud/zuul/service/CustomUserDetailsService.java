package com.sud.zuul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sud.zuul.model.CustomUserDetails;
import com.sud.zuul.model.User;
import com.sud.zuul.repo.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user=repo.findByUserName(username);
		return new CustomUserDetails(user);
	}

}
