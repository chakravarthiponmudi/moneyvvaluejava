package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.DomainObject;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.virtualproxy.TransactionListProxy;

public class AccountMapper extends AbstractMapper {
	public static Account find(int id) {
		return null;
	}
	
	@Override
	protected String findByStatement(Object o) {
		return "SELECT ACCOUNT.* FROM ACCOUNT,ACCOUNTMAP WHERE ACCOUNTMAP.ACCOUNTID = ACCOUNT.ID and ACCOUNTMAP.PERSONID =" + ((Person) o).getId(); 
	}
	
	
	@SuppressWarnings("unchecked")
	protected DomainObject doLoad(ResultSet rs) throws SQLException {
	    String  name = rs.getString("NAME");
	    String  type = rs.getString("TYPE");
	    double balance = rs.getDouble("BALANCE");
	    Account account = new Account(name,type,balance);
	    account.setTransactionList(new TransactionListProxy(account));
	    return account;
	}
	
	public List<Account> findByPerson(Person p) {
		ArrayList<Account> accountList = this.abstractFindBy(p);
		return accountList;
	}
	
	public static int update(Account family) {
		return 0;
	}
	
	public static int delete(Account family) {
		return 0;
	}
	
	public static Account create(Account family) {
		return null;
	}

	@Override
	protected String findStatement(Object o) {
		// TODO Auto-generated method stub
		return null;
	}



	
}