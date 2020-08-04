package com.soct.ott.ms.service;

import java.util.List;

import com.soct.ott.ms.dto.PaymentDto;
import com.soct.ott.ms.entities.Payment;
import com.soct.ott.ms.entities.Subscription;

public interface PaymentService {

	List<Payment> getPayments(String userId);
	
	Payment save(PaymentDto paymentDto);
	
	List<Subscription> getSubscriptions();
}
