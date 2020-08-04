package com.soct.ott.ms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soct.ott.ms.entities.PaymentEntity;
import com.soct.ott.ms.entities.SubscriptionEntity;
import com.soct.ott.ms.service.PaymentService;

@RestController
@RequestMapping("/users/{id}/payments")
public class PaymentController {
	
	PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping("/status/check")
	public String check() {
		return "Payment service - hello world";
	}
	
	@PostMapping
    public PaymentEntity savePayment(@PathVariable int id) {
        return paymentService.save(id);
    }
	
	
	@GetMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<PaymentEntity> userPayments(@PathVariable String id) {

        List<PaymentEntity> paymentEntities = paymentService.getPayments(id);
        
        if(paymentEntities == null || paymentEntities.isEmpty())
        {
            return new ArrayList<PaymentEntity>();
        }
        
        return paymentEntities;
    }
	
}

