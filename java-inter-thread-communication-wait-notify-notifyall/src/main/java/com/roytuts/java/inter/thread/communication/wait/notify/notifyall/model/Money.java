package com.roytuts.java.inter.thread.communication.wait.notify.notifyall.model;

import com.roytuts.java.inter.thread.communication.wait.notify.notifyall.enums.Currency;

public class Money {

	private double amount;
	private Currency currency;

	public Money(double amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

}
