package com.soct.ott.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soct.ott.api.dtos.UserDto;
import com.soct.ott.api.services.UserService;

@RestController
@RequestMapping("/users1")
public class UserController {

	@Autowired
	private Environment env;

	@Autowired
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/status")
	public String check() {
		return "Working on port: " + env.getProperty("local.server.port");
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
		UserDto userDto = userService.getUserByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}
}
