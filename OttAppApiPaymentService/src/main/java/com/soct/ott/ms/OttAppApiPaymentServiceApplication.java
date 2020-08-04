package com.soct.ott.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableBinding(Sink.class)
public class OttAppApiPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttAppApiPaymentServiceApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT)
	public void processUserRegistration(String user) {
		System.out.println("User Registered by Client " + user);
	}

}
