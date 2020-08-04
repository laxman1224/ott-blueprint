package com.soct.ott.ms.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OttAppEurekaNamingServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OttAppEurekaNamingServerApplication.class, args);
	}
}
