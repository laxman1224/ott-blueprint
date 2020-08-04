package com.soct.ott.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.soct.ott.api.message.channel.UserRegistrationSource;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
@EnableBinding(UserRegistrationSource.class)
public class OttAppUserApiLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttAppUserApiLauncherApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
