package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.Credit;
import com.moneyvalue.domain.Debit;
import com.moneyvalue.domain.Transaction;

public class TransactionMapper extends AbstractMapper {
	public List<Transaction> findByAccount(Account a) { 
		ArrayList<Transaction> transactionList = this.abstractFindBy(a);
		for(Transaction transaction: transactionList) {
			transaction.setAccount(a);
		}
		
		return transactionList;
	}

	@Override
	protected String findByStatement(Object o) {
		// TODO Auto-generated method stub
		return "SELECT * FROM TRANSACTION WHERE ACCOUNTID =" +  ((Account) o).getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Transaction doLoad(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		String  type = rs.getString("TYPE");
	    String  description = rs.getString("DESCRIPTION");
	    Date date = rs.getDate("TRANSACTION_DATE");
	    double amount = rs.getDouble("AMOUNT");
	    
	    Transaction transaction = type == "CR" ? new Credit(amount, type) : new Debit(amount, description);
	    return transaction;
	}

	@Override
	protected String findStatement(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
