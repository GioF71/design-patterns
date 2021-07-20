package com.gftech.designpatterns.builder.withbuilder;

import java.util.function.Function;

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

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		
		class BuilderException extends RuntimeException {

			private static final long serialVersionUID = 6142129777742872383L;

			public BuilderException(String message) {
				super(message);
			}
		}
		
		// mandatory, so it's verified before actually building "PersonWithBuilder"
		private String firstName;
		// mandatory, so it's verified before actually building "PersonWithBuilder"
		private String familyName;
		
		private String address;
		private String email;
		private String nickName;
		
		private Builder() {
		}
		
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder familyName(String familyName) {
			this.familyName = familyName;
			return this;
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
		
		private <T> void verifyMandatory(String fieldName, T fieldValue, Function<T, Boolean> verifier) {
			if (!verifier.apply(fieldValue)) {
				throw new BuilderException(String.format("Mandatory field [%s] is missing", fieldName));
			}
		}
		
		private Function<String, Boolean> validString = new Function<String, Boolean>() {
			
			@Override
			public Boolean apply(String t) {
				return t != null && t.length() > 0;
			}
		};
		
		public PersonWithBuilder build() {
			verifyMandatory("firstName", firstName, validString);
			verifyMandatory("familyName", familyName, validString);
			return new PersonWithBuilder(this);
		}
	}
}
