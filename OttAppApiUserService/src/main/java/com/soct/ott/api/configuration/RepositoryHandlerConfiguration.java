package com.soct.ott.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soct.ott.api.handler.UserRepositoryEventHandler;

@Configuration
public class RepositoryHandlerConfiguration {

	@Bean
	public UserRepositoryEventHandler userRepositoryEventHandler() {
		return new UserRepositoryEventHandler();
	}
}
