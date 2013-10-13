package com.croeder.password_validation.rules;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;


public class TrueValidator {

	Pair<Boolean, String>  validate(String password) {
		return new ImmutablePair(true, "All passwords are good today!");
	}
}


