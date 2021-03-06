/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;

import org.jvnet.hk2.annotations.Service;

@Service
public class AppValidator implements PasswordValidator {

     private static Rule word  = new RegexRule("\\w+", "");
     private static Rule digit = new RegexRule(".*\\d.*", "");
     private static Rule upper = new RegexRule(".*[A-Z].*", "");
     private static Rule lower = new RegexRule(".*[a-z].*", "");
     private static Rule length = new LengthRule(5,12);

	public Pair<Boolean, String>  validate(String password) {
		boolean good = 
				word.validate(password)		
			&&	digit.validate(password)
			&&	upper.validate(password)
			&&	lower.validate(password)
			&&	length.validate(password);

		String reason = 
				word.getGuidelines() + "\n"
			+  digit.getGuidelines() + "\n"
			+  upper.getGuidelines() + "\n"
			+  lower.getGuidelines() + "\n"
			+  length.getGuidelines() + "\n";

		return new ImmutablePair(good, reason);
	}
}


