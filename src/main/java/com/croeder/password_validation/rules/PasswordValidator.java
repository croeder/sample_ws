package com.croeder.password_validation.rules;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;


public interface PasswordValidator {

	Pair<Boolean, String>  validate(String password);

}


