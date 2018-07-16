package com.moneyvalue.domain;

public class Debit implements Transaction {

	public double amount;
	@Override
	public double apply() {
		// TODO Auto-generated method stub
		return -this.amount;
	}

}
