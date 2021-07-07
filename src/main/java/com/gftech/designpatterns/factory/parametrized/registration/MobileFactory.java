package com.gftech.designpatterns.factory.parametrized.registration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MobileFactory {
	
	private static final Map<MobilePhoneType, Supplier<MobilePhone>> mobilePhoneTypeMap = new HashMap<>();
	
	static void register(MobilePhoneType mobilePhoneType, Supplier<MobilePhone> supplier) {
		mobilePhoneTypeMap.put(mobilePhoneType, supplier);
	}
	
	public MobilePhone create(MobilePhoneType mobilePhoneType) {
		return Optional.of(mobilePhoneType)
			.map(x -> mobilePhoneTypeMap.get(x))
			.map(Supplier::get)
			.orElseThrow(() -> new RuntimeException(String.format("Invalid argument [%s]", mobilePhoneType)));
	}
}
