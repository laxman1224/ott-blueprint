package com.soct.ott.ms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OttAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttAppConfigServerApplication.class, args);
	}
}
