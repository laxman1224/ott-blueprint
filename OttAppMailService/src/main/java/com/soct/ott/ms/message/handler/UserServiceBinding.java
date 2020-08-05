package com.soct.ott.ms.message.handler;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserServiceBinding {

	String USER_SERVICE = "userServiceChannel";
	
	@Input(USER_SERVICE)
    SubscribableChannel greeting();
}
