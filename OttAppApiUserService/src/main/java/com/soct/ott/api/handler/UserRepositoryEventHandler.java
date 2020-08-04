package com.soct.ott.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.integration.support.MessageBuilder;

import com.soct.ott.api.entities.User;
import com.soct.ott.api.message.channel.UserRegistrationSource;

@RepositoryEventHandler
public class UserRepositoryEventHandler {

	@Autowired
	UserRegistrationSource userRegistrationSource;

	@HandleBeforeCreate
	public void handlePaymentBeforeCreate(User user) {
		System.out.println("@HandleBeforeCreate");
	}

	@HandleBeforeSave
	public void handlePaymentBeforeSave(User user) {
		System.out.println("@HandleBeforeSave");
	}

	@HandleAfterCreate
	public void handlePaymentAfterCreate(User user) {
		userRegistrationSource.userRegistration().send(MessageBuilder.withPayload(user).build());
		System.out.println("@HandleAfterCreate");
	}

	@HandleAfterSave
	public void handlePaymentAfterSave(User user) {
		System.out.println("@HandleAfterSave");
	}
}
