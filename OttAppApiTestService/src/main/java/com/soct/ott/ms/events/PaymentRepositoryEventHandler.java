package com.soct.ott.ms.events;

import java.util.Calendar;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.soct.ott.ms.entities.Payment;
import com.soct.ott.ms.entities.Subscription;

@RepositoryEventHandler
public class PaymentRepositoryEventHandler {

	@HandleBeforeCreate
	public void handlePaymentBeforeCreate(Payment payment) {
		/*Calendar calendar = Calendar.getInstance();
		Subscription subscription = payment.getSubscription();
		int termCount = subscription.getTermCount();
		calendar.add(Calendar.MONTH, (subscription.getTerm().equalsIgnoreCase("year") ? (termCount * 12) : termCount));
		payment.setExpireAt(calendar.getTime());
		*/
		System.out.println("@HandleBeforeCreate");
	}
	
	@HandleBeforeSave
	public void handlePaymentBeforeSave(Payment payment) {
		System.out.println("@HandleBeforeSave");
	}
	
	@HandleAfterCreate
	public void handlePaymentAfterCreate(Payment payment) {
		System.out.println("@HandleAfterCreate");
	}
	
	@HandleAfterSave
	public void handlePaymentAfterSave(Payment payment) {
		System.out.println("@HandleAfterSave");
	}
}
