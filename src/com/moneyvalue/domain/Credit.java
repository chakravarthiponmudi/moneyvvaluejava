package com.moneyvalue.domain;

public class Credit extends Transaction {


	public Credit(int id, double amount, String description) {
		super(id, amount, description);
	}

	@Override
	public double apply() {
		return this.amount;
	}

}
