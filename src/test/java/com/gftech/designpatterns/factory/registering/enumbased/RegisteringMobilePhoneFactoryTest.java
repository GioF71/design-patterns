package com.gftech.designpatterns.factory.registering.enumbased;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gftech.designpatterns.factory.registering.enumbased.FactoryInitializer;
import com.gftech.designpatterns.factory.registering.enumbased.MobileFactory;
import com.gftech.designpatterns.factory.registering.enumbased.MobilePhoneType;

public class RegisteringMobilePhoneFactoryTest {

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
