package com.gftech.designpatterns.builder.withbuilder;

import com.gftech.designpatterns.builder.Person;

public class PersonWithBuilder implements Person {

	private final String firstName;
	private final String familyName;
	private final String address;
	private final String email;
	private final String nickName;
	
	private PersonWithBuilder(Builder builder) {
		this.firstName = builder.firstName;
		this.familyName = builder.familyName;
		this.address = builder.address;
		this.email = builder.email;
		this.nickName = builder.nickName;
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

	public static Builder builder(String firstName, String familyName) {
		return new Builder(firstName, familyName);
	}
	
	public static class Builder {
		
		// mandatory, so it's final and it's required on the Builder constructor
		private final String firstName;
		// mandatory, so it's final and it's required on the Builder constructor
		private final String familyName;
		
		private String address;
		private String email;
		private String nickName;
		
		private Builder(String firstName, String familyName) {
			this.firstName = firstName;
			this.familyName = familyName;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder nickName(String nickName) {
			this.nickName = nickName;
			return this;
		}
		
		public PersonWithBuilder build() {
			return new PersonWithBuilder(this);
		}
	}
}
