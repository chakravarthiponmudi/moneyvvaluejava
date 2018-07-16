package com.moneyvalue.domain;

public class Account {
	private Transaction[] transactions;
	private int id;
	private String name;
	private double balance;
	Account (Transaction[] trans, int id, String name, double balance) {
		this.id = id;
		this.transactions = trans;
		this.name = name;
		this.balance = balance;
	}
	
	public String toString() {
		String description = "Account Name :" + this.name + "\n\tid:" + this.id + "\n\tBalance:" + this.balance;	
		return description;
		
	}
}
