package com.gftech.designpatterns.factory.parametrized.registration;

public class FactoryInitializer {
	
	static void initialize() {
		MobileFactory.register(MobilePhoneType.ANDROID, () -> new AndroidPhone());
		MobileFactory.register(MobilePhoneType.NOKIA, () -> new NokiaPhone());
		MobileFactory.register(MobilePhoneType.IPHONE, () -> new Iphone());
	}
	
	private FactoryInitializer() {
		
	}
}
