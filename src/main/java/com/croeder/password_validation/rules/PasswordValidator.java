/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface PasswordValidator {

	Pair<Boolean, String>  validate(String password);

}


