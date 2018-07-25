package com.moneyvalue.domain;

public class Credit extends Transaction {


	public Credit(double amount, String description) {
		super(amount, description);
	}

	@Override
	public double apply() {
		return this.amount;
	}

}
