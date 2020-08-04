package com.soct.ott.ms.service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soct.ott.ms.entities.PaymentEntity;
import com.soct.ott.ms.entities.SubscriptionEntity;
import com.soct.ott.ms.repositories.PaymentRepository;
import com.soct.ott.ms.repositories.SubscriptionRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Override
	public List<PaymentEntity> getPayments(String userId) {
		return paymentRepository.findAll();
	}

	@Override
	public PaymentEntity save(int userId) {
		PaymentEntity entity = new PaymentEntity();
		int randId = this.getRandomNumber(1, 4);
		SubscriptionEntity subscription = subscriptionRepository.findById(Long.valueOf(randId)).orElse(null);
		entity.setSubscription(subscription);
		entity.setUserId(userId);
		
		Calendar calendar = Calendar.getInstance();
		int termCount = subscription.getTermCount();
		calendar.add(Calendar.MONTH, (subscription.getTerm().equalsIgnoreCase("year") ? (termCount * 12) : termCount));
		entity.setExpireAt(calendar.getTime());
		
		return paymentRepository.save(entity);
	}
	
	private int getRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max-min+1)+min;
	}

	@Override
	public List<SubscriptionEntity> getSubscriptions() {
		return subscriptionRepository.findAll();
	}

}
