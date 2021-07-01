package com.gftech.factory.parametrized;

import org.junit.Test;

import com.gftech.factory.parametrized.MobileFactory;
import com.gftech.factory.parametrized.MobilePhoneType;

public class MobileFactoryTest {

	@Test
	public void apple() {
		System.out.println(new MobileFactory().create(MobilePhoneType.IPHONE).getName());
	}
	
	@Test
	public void android() {
		System.out.println(new MobileFactory().create(MobilePhoneType.ANDROID).getName());
	}

	@Test
	public void nokia() {
		System.out.println(new MobileFactory().create(MobilePhoneType.NOKIA).getName());
	}

	@Test(expected = RuntimeException.class)
	public void nullPhoneType() {
		System.out.println(new MobileFactory().create(null).getName());
	}
}
