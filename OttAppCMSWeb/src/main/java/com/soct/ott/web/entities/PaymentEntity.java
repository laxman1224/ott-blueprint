package com.soct.ott.web.entities;

import java.util.Date;

public class PaymentEntity {

	private long id;

	private int userId;

	private SubscriptionEntity subscription;

	private Date expireAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public SubscriptionEntity getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionEntity subscription) {
		this.subscription = subscription;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

}
