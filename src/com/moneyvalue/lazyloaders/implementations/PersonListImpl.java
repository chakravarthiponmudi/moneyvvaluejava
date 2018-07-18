package com.moneyvalue.lazyloaders.implementations;

import java.util.List;

import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.PersonList;

public class PersonListImpl implements PersonList {
	
	private Family familyObj;
j
	public PersonListImpl(Family familyObj) {
		// TODO Auto-generated constructor stub
		this.familyObj = familyObj;
	}

	@Override
	public List<Person> getPerson() {
		// TODO Auto-generated method stub
		PersonMapper.findByFamilyID(familyObj.getId());
		return null;
	}

}
