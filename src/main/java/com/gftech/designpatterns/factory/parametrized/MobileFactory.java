package com.gftech.designpatterns.factory.parametrized;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MobileFactory {
	
	private final Map<MobilePhoneType, Supplier<MobilePhone>> mobilePhoneTypeMap = new HashMap<>();
	
	public MobileFactory() {
		mobilePhoneTypeMap.put(MobilePhoneType.IPHONE, () -> new Iphone());
		mobilePhoneTypeMap.put(MobilePhoneType.ANDROID, () -> new AndroidPhone());
		mobilePhoneTypeMap.put(MobilePhoneType.NOKIA, () -> new NokiaPhone());
	}
	
	public MobilePhone create(MobilePhoneType mobilePhoneType) {
		return Optional.of(mobilePhoneTypeMap)
			.map(x -> x.get(mobilePhoneType))
			.map(Supplier::get)
			.orElseThrow(() -> new RuntimeException(String.format("Invalid argument [%s]", mobilePhoneType)));
	}
}
