package com.soct.ott.ms.service;

import java.util.List;

import com.soct.ott.ms.entities.PaymentEntity;
import com.soct.ott.ms.entities.SubscriptionEntity;

public interface PaymentService {

	List<PaymentEntity> getPayments(String userId);
	
	PaymentEntity save(int userId);
	
	List<SubscriptionEntity> getSubscriptions();
}
