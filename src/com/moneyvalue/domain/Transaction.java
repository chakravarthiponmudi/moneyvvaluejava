package com.moneyvalue.domain;
public abstract class Transaction  extends DomainObject {

	protected int id;
	protected String description;
	protected  double amount;
	protected Account account;
	
	public Transaction(int id, double amount, String description) {
		this.id = id;
		this.amount = amount;
		this.description = description;
	}
	
	public abstract double apply() ;

	public void setAccount(Account account) {
		this.account = account;
	}

}