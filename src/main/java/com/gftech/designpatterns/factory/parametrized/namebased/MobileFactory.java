package com.gftech.designpatterns.factory.parametrized.namebased;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MobileFactory {
	
	private final Map<String, Supplier<MobilePhone>> mobilePhoneTypeMap = new HashMap<>();
	
	public MobileFactory() {
		mobilePhoneTypeMap.put(MobilePhoneType.IPHONE.name(), () -> new Iphone());
		mobilePhoneTypeMap.put(MobilePhoneType.ANDROID.name(), () -> new AndroidPhone());
		mobilePhoneTypeMap.put(MobilePhoneType.NOKIA.name(), () -> new NokiaPhone());
	}
	
	public MobilePhone create(String mobilePhoneType) {
		return Optional.of(mobilePhoneType)
			.map(s -> s.toUpperCase())
			.map(x -> mobilePhoneTypeMap.get(x))
			.map(Supplier::get)
			.orElseThrow(() -> new RuntimeException(String.format("Invalid argument [%s]", mobilePhoneType)));
	}
}
