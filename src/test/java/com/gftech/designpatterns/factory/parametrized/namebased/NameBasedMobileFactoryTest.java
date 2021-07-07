package com.gftech.designpatterns.factory.parametrized.namebased;

import org.junit.Test;

public class NameBasedMobileFactoryTest {

	@Test
	public void apple() {
		System.out.println(new MobileFactory().create(MobilePhoneType.IPHONE.name()).getName());
	}
	
	@Test
	public void android() {
		System.out.println(new MobileFactory().create(MobilePhoneType.ANDROID.name()).getName());
	}

	@Test
	public void nokia() {
		System.out.println(new MobileFactory().create(MobilePhoneType.NOKIA.name()).getName());
	}

	@Test
	public void nokiaFromLowerCase() {
		System.out.println(new MobileFactory().create(MobilePhoneType.NOKIA.name().toLowerCase()).getName());
	}

	@Test(expected = RuntimeException.class)
	public void unknownPhoneType() {
		System.out.println(new MobileFactory().create("unknown").getName());
	}

	@Test(expected = RuntimeException.class)
	public void nullPhoneType() {
		System.out.println(new MobileFactory().create(null).getName());
	}
}
