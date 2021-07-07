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

	@Test
	public void withoutBuilderAllSet() {
		Person p = new PersonWithoutBuilder(FIRST_NAME, FAMILY_NAME, ADDRESS, EMAIL, NICKNAME);
		validateAll(p);
	}

	@Test
	public void withoutBuilderMandatoryOnly() {
		// cool, I have a perfect constructor for that!
		Person p = new PersonWithoutBuilder(FIRST_NAME, FAMILY_NAME);
		validateMandatory(p);
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
	public void withBuilderMandatoryOnly() {
		Person p = PersonWithBuilder.builder(FIRST_NAME, FAMILY_NAME)
			.build();
		validateMandatory(p);
	}

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
