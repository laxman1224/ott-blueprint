package com.soct.ott.ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soct.ott.ms.entities.Subscription;

public interface SubscriptionRepository  extends JpaRepository<Subscription, Long>{

}
