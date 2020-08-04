package com.soct.ott.ms.events;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.soct.ott.ms.entities.Payment;

public class PaymentRepositoryEventListener {

	@PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Payment payment) {
		System.out.println("Before payment update: "+payment);
    }
    
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Payment payment) {
    	System.out.println("after payment update: "+payment);
    }
}
