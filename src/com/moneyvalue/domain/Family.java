package com.moneyvalue.domain;

import java.util.List;

import com.moneyvalue.lazyloaders.PersonList;

public class Family {
	private PersonList memberList;
	private int id;
	private String name;
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Family(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<Person> getMembers() {
		return memberList.getPerson();
	}

	public void setMemberList(PersonList members) {
		this.memberList = members;
	}
}
