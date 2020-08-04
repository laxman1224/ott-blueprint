package com.soct.ott.ms.service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soct.ott.ms.dto.PaymentDto;
import com.soct.ott.ms.entities.Payment;
import com.soct.ott.ms.entities.Subscription;
import com.soct.ott.ms.repositories.PaymentRepository;
import com.soct.ott.ms.repositories.SubscriptionRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Override
	public List<Payment> getPayments(String userId) {
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(PaymentDto paymentDto) {
		Payment payment = new Payment();
		payment.setUserId(paymentDto.getUserId());
		int randId = this.getRandomNumber(1, 4);
		Subscription subscription = subscriptionRepository.findById(Long.valueOf(randId)).orElse(null);
		payment.setSubscription(subscription);
		
		Calendar calendar = Calendar.getInstance();
		int termCount = subscription.getTermCount();
		calendar.add(Calendar.MONTH, (subscription.getTerm().equalsIgnoreCase("year") ? (termCount * 12) : termCount));
		payment.setExpireAt(calendar.getTime());
		
		return paymentRepository.save(payment);
	}
	
	private int getRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max-min+1)+min;
	}

	@Override
	public List<Subscription> getSubscriptions() {
		return subscriptionRepository.findAll();
	}

}
