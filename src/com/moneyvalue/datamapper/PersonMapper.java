package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moneyvalue.database.utils.PostgreSQLJDBCConnection;
import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.virtualproxy.AccountListProxy;

public class PersonMapper {
	
	private static ResultSet getDomainObjectUsingSQL(String stmt) {
		PostgreSQLJDBCConnection connection = null;
		try {
			connection = new PostgreSQLJDBCConnection();
			return connection.executeQuery(stmt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	public static List<Person> findByFamilyID(Family family) {
		String sql = "SELECT * from PERSON where FAMILYID=" + family.getId();
		ArrayList<Person> personList = new ArrayList<Person>();
		ResultSet rs = getDomainObjectUsingSQL(sql);
		try {
			while ( rs.next() ) {
			    int id = rs.getInt("id");
			    String  fname = rs.getString("FIRSTNAME");
			    String  lname = rs.getString("LASTNAME");
			    Person personObj = new Person(id, fname, lname);
			    personObj.setFamily(family);
			    personObj.setAccountList(new AccountListProxy(personObj));
			    
			    personList.add(personObj);
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personList;
		
	}

}
