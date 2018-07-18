package com.moneyvalue.lazyloaders.virtualproxy;

import java.util.List;

import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;
import com.moneyvalue.lazyloaders.PersonList;
import com.moneyvalue.lazyloaders.implementations.PersonListImpl;

public class PersonListProxy implements PersonList {

	Family familyObj;
	public PersonListProxy(Family familyObj) {
		this.familyObj = familyObj;
	}
	@Override
	public List<Person> getPerson() {
		// TODO Auto-generated method stub
		new PersonListImpl(familyObj).getPerson()
	}

}