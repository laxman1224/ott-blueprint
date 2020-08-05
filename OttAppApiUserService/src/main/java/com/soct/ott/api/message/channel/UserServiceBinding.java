package com.soct.ott.api.message.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserServiceBinding {

	@Output("userServiceChannel")
	MessageChannel userRegistration();
}
