package com.moneyvalue.lazyloaders.implementations;

import java.util.List;

import com.moneyvalue.datamapper.PersonMapper;
import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.PersonList;

public class PersonListImpl implements PersonList {
	
	private Family familyObj;

	public PersonListImpl(Family familyObj) {
		// TODO Auto-generated constructor stub
		this.familyObj = familyObj;
	}


	@Override
	public List<Person> get() {
		// TODO Auto-generated method stub
		return PersonMapper.findByFamilyID(familyObj);
	}

	@Override
	public void add(Person obj) {
		// TODO Auto-generated method stub
		
	}

}
