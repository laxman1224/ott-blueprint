package com.soct.ott.api.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.soct.ott.api.dtos.UserDto;
import com.soct.ott.api.entities.User;

public interface UserService extends UserDetailsService {

	User save(User user);
	
	Iterable<User> all();
	
	User getUserDetailsByEmail(String email);
	
	UserDto getUserByUserId(String userId);
}
