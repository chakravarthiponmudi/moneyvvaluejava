package com.moneyvalue.domain;

import java.util.List;

import com.moneyvalue.lazyloaders.TransactionList;

public class Account {
	private TransactionList transactionList;
	private int id;
	private String type;
	private String name;
	private double balance;
	public Account (int id, String name, String type, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		String description = "Account Name :" + this.name + "\n\tid:" + this.id + "\n\tBalance:" + this.balance;	
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
