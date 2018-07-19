package com.moneyvalue.domain;

public class Debit extends Transaction {

	public Debit(int id, double amount, String description) {
		super(id, amount, description);
		// TODO Auto-generated constructor stub
	}

	public double apply() {
		// TODO Auto-generated method stub
		return -this.amount;
	}

}
