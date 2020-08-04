package com.soct.ott.api.entities;

public class PaymentEntity {

	private long id;
	private String userId;
	private String paymentId;
	private double amount;
	private String subscriptionName;
	private String subscriptionTerm;
	private int subscriptionInterval;

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

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public String getSubscriptionTerm() {
		return subscriptionTerm;
	}

	public void setSubscriptionTerm(String subscriptionTerm) {
		this.subscriptionTerm = subscriptionTerm;
	}

	public int getSubscriptionInterval() {
		return subscriptionInterval;
	}

	public void setSubscriptionInterval(int subscriptionInterval) {
		this.subscriptionInterval = subscriptionInterval;
	}

}
