package com.soct.ott.ms.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.soct.ott.ms.dto.PaymentDto;
import com.soct.ott.ms.entities.Payment;
import com.soct.ott.ms.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody PaymentDto paymentDto) {
		System.out.println(paymentDto);
		
		Payment payment = paymentService.save(paymentDto);
		if (payment.getId() != 0) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(payment.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
		return ResponseEntity.noContent().build();
	} 
}
