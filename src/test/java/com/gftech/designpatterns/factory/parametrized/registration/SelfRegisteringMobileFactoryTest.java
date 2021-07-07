package com.gftech.designpatterns.factory.parametrized.registration;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gftech.designpatterns.factory.parametrized.registration.FactoryInitializer;
import com.gftech.designpatterns.factory.parametrized.registration.MobileFactory;
import com.gftech.designpatterns.factory.parametrized.registration.MobilePhoneType;

public class SelfRegisteringMobileFactoryTest {

	@BeforeClass 
	public static void setup() {
		FactoryInitializer.initialize();
	}
	
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
