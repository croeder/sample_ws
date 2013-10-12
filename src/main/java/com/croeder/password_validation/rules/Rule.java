package com.croeder.password_validator.rules;

public interface Rule {
	boolean validate(String password);
	String  getGuidelines();
}


