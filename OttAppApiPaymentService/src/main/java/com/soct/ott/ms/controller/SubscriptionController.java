package com.soct.ott.ms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soct.ott.ms.entities.SubscriptionEntity;
import com.soct.ott.ms.service.PaymentService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

	PaymentService paymentService;

	@Autowired
	public SubscriptionController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, })
	public List<SubscriptionEntity> subscriptions() {

		List<SubscriptionEntity> subscriptionEntities = paymentService.getSubscriptions();

		if (subscriptionEntities == null || subscriptionEntities.isEmpty()) {
			return new ArrayList<SubscriptionEntity>();
		}

		return subscriptionEntities;
	}
}
