package com.soct.ott.ms.entities;

import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.soct.ott.ms.events.PaymentRepositoryEventListener;

@Entity
@Table(name = "payments")
@EntityListeners(PaymentRepositoryEventListener.class)
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_id", referencedColumnName = "id")
	private Subscription subscription;

	private Date expireAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", userId=" + userId + ", subscription=" + subscription + ", expireAt=" + expireAt
				+ "]";
	}

}
