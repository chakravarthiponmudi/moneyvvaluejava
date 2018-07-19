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

public class TransactionMapper extends DomainMapper {
	public static List<Transaction> findByAccount(Account a) {
		String sql = "SELECT * FROM TRANSACTION WHERE ACCOUNTID =" + a.getId(); 
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		ResultSet rs = getDomainObjectUsingSQL(sql);
		try {
			while ( rs.next() ) {
			    int id = rs.getInt("id");
			    String  type = rs.getString("TYPE");
			    String  description = rs.getString("DESCRIPTION");
			    Date date = rs.getDate("TRANSACTION_DATE");
			    double amount = rs.getDouble("AMOUNT");
			    
			    Transaction transaction = type == "CR" ? new Credit(id, amount, type) : new Debit(id, amount, description);
			    transaction.setAccount(a);
			    transactionList.add(transaction);
			    
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionList;
	}
}
