package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.Person;

public class AccountMapper extends DomainMapper {
	public static Account find(int id) {
		return null;
	}
	
	public static List<Account> findByPerson(Person p) {
		String sql = "SELECT * FROM ACCOUNT WHERE PERSONID =" + p.getId(); 
		ArrayList<Account> accountList = new ArrayList<Account>();
		ResultSet rs = getDomainObjectUsingSQL(sql);
		try {
			while ( rs.next() ) {
			    int id = rs.getInt("id");
			    String  name = rs.getString("NAME");
			    String  type = rs.getString("TYPE");
			    double balance = rs.getDouble("BALANCE");
			    Account account = new Account(id,name,type,balance);
			    
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}