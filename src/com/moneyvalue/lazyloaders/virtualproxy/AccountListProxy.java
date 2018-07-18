package com.moneyvalue.lazyloaders.virtualproxy;

import java.util.List;

import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.AccountList;
import com.moneyvalue.lazyloaders.implementations.AccountListImpl;

public class AccountListProxy implements AccountList {
	
	private Person personObj;
	private AccountListImpl accountListImplObj = null;

	public AccountListProxy(Person personObj) {
		this.personObj = personObj;
	}

	@Override
	public List<Account> getAccounts() {
		if (accountListImplObj == null) {
			accountListImplObj = new AccountListImpl(personObj);
		}
		return accountListImplObj.getAccounts();
	}

}
