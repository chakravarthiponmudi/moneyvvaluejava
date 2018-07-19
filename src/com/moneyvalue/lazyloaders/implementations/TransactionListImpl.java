package com.moneyvalue.lazyloaders.implementations;

import java.util.List;

import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.Transaction;
import com.moneyvalue.lazyloaders.TransactionList;

public class TransactionListImpl implements TransactionList {
	
	private Account account;
	public TransactionListImpl(Account account) {
		this.account = account;
	}

	@Override
	public List<Transaction> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Transaction obj) {
		// TODO Auto-generated method stub

	}

}
