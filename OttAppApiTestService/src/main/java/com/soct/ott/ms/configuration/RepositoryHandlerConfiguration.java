package com.soct.ott.ms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soct.ott.ms.events.PaymentRepositoryEventHandler;

@Configuration
public class RepositoryHandlerConfiguration {

	@Bean
	public PaymentRepositoryEventHandler paymentRepositoryEventHandler() {
		return new PaymentRepositoryEventHandler();
	} 
}
