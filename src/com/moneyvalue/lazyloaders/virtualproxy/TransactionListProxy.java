package com.moneyvalue.lazyloaders.virtualproxy;

import java.util.List;

import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.Transaction;
import com.moneyvalue.lazyloaders.TransactionList;
import com.moneyvalue.lazyloaders.implementations.TransactionListImpl;

public class TransactionListProxy implements TransactionList {
	
	private Account account;
	private TransactionListImpl tList;

	public TransactionListProxy(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
		
	}

	@Override
	public List<Transaction> get() {
		if (tList == null) {
			tList = new TransactionListImpl(account);
		}
		return tList.get();
	}

	@Override
	public void add(Transaction obj) {
		// TODO Auto-generated method stub
		
	}

}
