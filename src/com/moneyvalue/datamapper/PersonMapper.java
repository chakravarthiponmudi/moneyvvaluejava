package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.virtualproxy.AccountListProxy;

public class PersonMapper extends AbstractMaper {
	
	public List<Person> findByFamilyID(Family family) {
		ArrayList<Person> personList = this.abstractFindBy(family);
		List<Person> pList = personList.stream().map(person -> person.setFamily(familyObj)).collect(Collectors.toList());
		return pList;
		
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
		int id = rs.getInt("id");
	    String  fname = rs.getString("FIRSTNAME");
	    String  lname = rs.getString("LASTNAME");
	    Person personObj = new Person(id, fname, lname);
//	    personObj.setFamily(family);
	    personObj.setAccountList(new AccountListProxy(personObj));
		return personObj;
	}

}
