package com.soct.ott.ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soct.ott.ms.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
