package com.moneyvalue.domain;

public class Credit implements Transaction {

	private  double amount;
	private String description;
	
	Credit(double amount, String description) {
		this.amount = amount;
		this.description = description;
	}
	@Override
	public double apply() {
		// TODO Auto-generated method stub
		
		return this.amount;
	}

}
