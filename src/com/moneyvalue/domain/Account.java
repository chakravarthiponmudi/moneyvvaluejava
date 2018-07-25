package com.moneyvalue.domain;

import java.util.List;

import com.moneyvalue.lazyloaders.TransactionList;

public class Account extends DomainObject{
	private TransactionList transactionList;
	private String type;
	private String name;
	private double balance;
	public Account (String name, String type, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	
	public String toString() {
		String description = "Account Name :" + this.name + "\n\tid:" + this.getId() + "\n\tBalance:" + this.balance;	
		return description;
		
	}
	
	public void setTransactionList(TransactionList tList) {
		this.transactionList = tList;
	}
	
	public List<Transaction> getTransactions() {
		return transactionList.get();
	}
	
	public void addIncome() {
		
	}
	
	public void addExpense() {
		
	}
	
	public void addIncomeReversal() {
		
	}
	
	public void addExpenseReversal() {
		
	}
}
