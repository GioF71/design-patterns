package com.gftech.designpatterns.builder;

import org.junit.Assert;
import org.junit.Test;

import com.gftech.designpatterns.builder.withbuilder.PersonWithBuilder;
import com.gftech.designpatterns.builder.withoutbuilder.PersonWithoutBuilder;

public class BuilderTest {
	
	private static final String FIRST_NAME = "first_name";
	private static final String FAMILY_NAME = "family_name";
	private static final String ADDRESS = "address";
	private static final String EMAIL = "a@b.c";
	private static final String NICKNAME = "nickname";
	
	
	// Case 1: I need a Person Object with only mandatory properties.
	// With Builder and Without Builder is almost the same (If I take a look, it seems there is no real benefit !)
	
	@Test
	public void withoutBuilderMandatoryOnly() {
		// cool, I have a perfect constructor for that!
		Person p = new PersonWithoutBuilder(FIRST_NAME, FAMILY_NAME);
		validateMandatory(p);
	}

	@Test
	public void withBuilderMandatoryOnly() {
		Person p = PersonWithBuilder.builder(FIRST_NAME, FAMILY_NAME)
			.build();
		validateMandatory(p);
	}
	
	// Case 2: I need a Person Object with all properties set.
	// Without Builder: there is no problem here, however all parameters are string and you need to respect the order.
	// With Builder: code is more readable and you are not required to respect the order of the methods of the builder.
	
	@Test
	public void withoutBuilderAllSet() {
		Person p = new PersonWithoutBuilder(FIRST_NAME, FAMILY_NAME, ADDRESS, EMAIL, NICKNAME);
		validateAll(p);
	}
	
	@Test
	public void withBuilderAllSet() {
		Person p = PersonWithBuilder.builder(FIRST_NAME, FAMILY_NAME)
			.address(ADDRESS)
			.email(EMAIL)
			.nickName(NICKNAME)
			.build();
		validateAll(p);
	}
	
	@Test
	public void withBuilderAllSetDifferentOrder() {
		Person p = PersonWithBuilder.builder(FIRST_NAME, FAMILY_NAME)
			.address(ADDRESS)
			.nickName(NICKNAME)
			.email(EMAIL)
			.build();
		validateAll(p);
	}
	
	// Case 3: I need a Person Object with mandatory properties and the email.
	// Without Builder: I don't have an ad-hoc constructor ! I use the overload constructor with 4 parameters but  
	// I need to pass "null" as the address (third parameter).
	
	@Test
	public void withoutBuilderMandatoryAndEmail() {
		// uh-oh!
		// what's that 'null' down there?
		Person p = new PersonWithoutBuilder(FIRST_NAME, FAMILY_NAME, null, EMAIL);
		validateMandatory(p);
		validateEmail(p);
	}

	@Test
	public void withBuilderMandatoryAndEmail() {
		// no problem with the builder here!
		Person p = PersonWithBuilder.builder(FIRST_NAME, FAMILY_NAME)
			.email(EMAIL)
			.build();
		validateMandatory(p);
		validateEmail(p);
	}
	
	// Case 4: I need a Person Object with mandatory properties and the nickname.
	// Without Builder: I don't have an ad-hoc constructor ! I use the overload constructor with 5 parameters but  
	// I need to pass "null" as the address (third parameter) and "null" as email (fourth parameter). 
	
	@Test
	public void withoutBuilderMandatoryAndNickName() {
		// uh-oh! even worse!
		// what are those 'null's down there?
		Person p = new PersonWithoutBuilder(FIRST_NAME, FAMILY_NAME, null, null, NICKNAME);
		validateMandatory(p);
		validateNickName(p);
	}

	@Test
	public void withBuilderMandatoryAndNickName() {
		// no problem with the builder here!
		Person p = PersonWithBuilder.builder(FIRST_NAME, FAMILY_NAME)
			.nickName(NICKNAME)
			.build();
		validateMandatory(p);
		validateNickName(p);
	}
	
	// Validator methods
	
	private void validateMandatory(Person p) {
		Assert.assertEquals(p.getFirstName(), FIRST_NAME);
		Assert.assertEquals(p.getFamilyName(), FAMILY_NAME);
	}
	
	private void validateAll(Person p) {
		validateMandatory(p);
		validateAddress(p);
		validateEmail(p);
		validateNickName(p);
	}

	private void validateNickName(Person p) {
		Assert.assertEquals(p.getNickName(), NICKNAME);
	}

	private void validateAddress(Person p) {
		Assert.assertEquals(p.getAddress(), ADDRESS);
	}

	private void validateEmail(Person p) {
		Assert.assertEquals(p.getEmail(), EMAIL);
	}
}
