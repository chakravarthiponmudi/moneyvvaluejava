package com.moneyvalue.domain;

import java.util.List;

import com.moneyvalue.lazyloaders.AccountList;

public class Person {
	private AccountList accountList;
	private Family family;
	private int id;
	private String fname;
	private String lname;
	
	public void setFamily(Family familyObj) {
		this.family = familyObj;
	}
	 
	public void setAccountList(AccountList accountList) {
		this.accountList = accountList;
	}
	
	public Person(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}
	
	public List<Account> getAccounts() {
		return accountList.getAccounts();
	}
	
	public void spend() {
		
	}
	
	public void earn() {
		
	}
	
}
