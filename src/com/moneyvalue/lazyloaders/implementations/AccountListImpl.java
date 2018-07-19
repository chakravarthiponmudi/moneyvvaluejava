package com.moneyvalue.lazyloaders.implementations;


import java.util.List;

import com.moneyvalue.datamapper.AccountMapper;
import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.AccountList;

public class AccountListImpl implements AccountList {
	
	private Person personObj;

	public AccountListImpl(Person personObj) {
		// TODO Auto-generated constructor stub
		this.personObj = personObj;
	}

	@Override
	public List<Account> get() {
		// TODO Auto-generated method stub
		return AccountMapper.findByPerson(this.personObj);
	}

	@Override
	public void add(Account obj) {
		// TODO Auto-generated method stub
		
	}

}
