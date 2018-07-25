package com.moneyvalue.domain;

import java.util.List;

import com.moneyvalue.lazyloaders.PersonList;

public class Family  extends DomainObject {
	private PersonList memberList;
	private String name;
	

	
	public String getName() {
		return this.name;
	}
	
	public Family(String name) {
		this.name = name;
	}

	public List<Person> getMembers() {
		return memberList.get();
	}

	public void setMemberList(PersonList members) {
		this.memberList = members;
	}
}
