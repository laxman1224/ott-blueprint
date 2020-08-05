package com.soct.ott.ms.message.handler;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(UserServiceBinding.class)
public class EmailServiceMessageListener {

	@StreamListener(target=UserServiceBinding.USER_SERVICE)
	public void processUserRegistration(String userId) {
		System.out.println("Email service message handler: "+ userId);
	}
}
