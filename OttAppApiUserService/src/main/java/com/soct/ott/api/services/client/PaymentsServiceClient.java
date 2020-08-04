package com.soct.ott.api.services.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.soct.ott.api.entities.PaymentEntity;

//@FeignClient(name="payments-ws")
public interface PaymentsServiceClient {

	@GetMapping("/users/{id}/payments")
	public List<PaymentEntity> getPayments(@PathVariable String id);

	@PostMapping("/users/{id}/payments")
	public PaymentEntity save(@PathVariable Long id);
}
