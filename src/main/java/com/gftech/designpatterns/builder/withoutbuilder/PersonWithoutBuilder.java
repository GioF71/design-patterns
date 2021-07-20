package com.gftech.designpatterns.builder.withoutbuilder;

import com.gftech.designpatterns.builder.Person;

public class PersonWithoutBuilder implements Person {
	
	// mandatory, so it's final
	private final String firstName;
	// mandatory, so it's final
	private final String familyName;
	private String address;
	private String email;
	private String nickName;

	public PersonWithoutBuilder(String firstName, String familyName) {
		this.firstName = firstName;
		this.familyName = familyName;
	}

	public PersonWithoutBuilder(String firstName, String familyName, String address) {
		this(firstName, familyName);
		this.address = address;
	}

	public PersonWithoutBuilder(String firstName, String familyName, String address, String email) {
		this(firstName, familyName, address);
		this.email = email;
	}

	public PersonWithoutBuilder(String firstName, String familyName, String address, String email, String nickName) {
		this(firstName, familyName, address, email);
		this.nickName = nickName;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getNickName() {
		return nickName;
	}
}
