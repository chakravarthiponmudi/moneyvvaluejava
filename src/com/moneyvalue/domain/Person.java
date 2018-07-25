package com.moneyvalue.domain;

import java.util.List;

import com.moneyvalue.lazyloaders.AccountList;

public class Person  extends DomainObject{
	private AccountList accountList;
	private Family family;
	private String fname;
	private String lname;
	
	public void setFamily(Family familyObj) {
		this.family = familyObj;
	}
	 
	public void setAccountList(AccountList accountList) {
		this.accountList = accountList;
	}
	

	public Person(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public List<Account> getAccounts() {
		return accountList.get();
	}
	
	public void spend() {
		
	}
	
	public void earn() {
		
	}
	
}
