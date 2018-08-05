package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.virtualproxy.AccountListProxy;

public class PersonMapper extends AbstractMapper {
	
	public List<Person> findByFamilyID(Family family) {
		ArrayList<Person> personList = this.abstractFindBy(family);
		for(Person person : personList) {
			person.setFamily(family);
		}
		return personList;
		
	}

	@Override
	protected String findByStatement(Object family) {
		// TODO Auto-generated method stub
		return  "SELECT * from PERSON where FAMILYID=" + ((Family) family).getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Person doLoad(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
	    String  fname = rs.getString("FIRSTNAME");
	    String  lname = rs.getString("LASTNAME");
	    Person personObj = new Person(fname, lname);
	    personObj.setAccountList(new AccountListProxy(personObj));
		return personObj;
	}

	@Override
	protected String findStatement(Object o) {
		// TODO Auto-generated method stub
		return null;
	}


}
