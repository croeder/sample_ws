/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;

public interface Rule {
	boolean validate(String password);
	String  getGuidelines();
}


