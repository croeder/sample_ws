package com.croeder.password_validator.rules;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;


public interface Validator {

	Pair<Boolean, String>  validate(String password);

}


