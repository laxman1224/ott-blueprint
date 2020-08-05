package com.soct.ott.ms.message.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.soct.ott.ms.service.PaymentService;

@EnableBinding(UserServiceBinding.class)
public class PaymentServiceMessageHandler {

	@Autowired
	PaymentService paymentService;
	
	@StreamListener(target=UserServiceBinding.USER_SERVICE)
	public void processUserRegistration(String userId) {
		System.out.println("User Registered by Client " + userId);
		paymentService.save(userId);
	}
}
