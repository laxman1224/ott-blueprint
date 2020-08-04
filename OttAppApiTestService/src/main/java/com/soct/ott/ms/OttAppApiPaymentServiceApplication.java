package com.soct.ott.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class OttAppApiPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttAppApiPaymentServiceApplication.class, args);
	}

}
