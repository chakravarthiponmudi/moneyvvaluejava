package com.moneyvalue.domain;
public abstract class Transaction  extends DomainObject {

	protected String description;
	protected  double amount;
	protected Account account;
	
	public Transaction(double amount, String description) {
		this.amount = amount;
		this.description = description;
	}
	
	public abstract double apply() ;

	public void setAccount(Account account) {
		this.account = account;
	}

}