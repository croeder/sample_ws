package com.croeder.password_validation.rules;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;

import org.jvnet.hk2.annotations.Service;

@Service
public class TrueValidator implements PasswordValidator{

	public Pair<Boolean, String>  validate(String password) {
		return new ImmutablePair(true, "All passwords are good today!");
	}
}


