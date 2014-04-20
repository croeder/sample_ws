/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.regex.PatternSyntaxException;

public class RegexRuleTest {

	@Test(expected = PatternSyntaxException.class)
	public void testConstructor() {
		Rule r = new RegexRule("some (]bogus pattern that doesn't compile", 
			"placeholder guideline message");
	}

	@Test 
	public void testValidate_characters() {
		Rule r = new RegexRule("\\w+", 
			"password must consist of only upper and lower case letters and/or digits");
		assertEquals("failed to validate()", false, r.validate("!@#$"));
	}

	@Test 
	public void testValidate_has_upper() {
		Rule r = new RegexRule(".*[A-Z].*", 
			"password must consist of only upper and lower case letters and/or digits");
		assertEquals("failed to validate()", true, r.validate("A"));
	}

	@Test 
	public void testValidate_has_lower() {
		Rule r = new RegexRule(".*[a-z].*", 
			"password must consist of only upper and lower case letters and/or digits");
		assertEquals("failed to validate()", true, r.validate("a"));
	}

	@Test 
	public void testValidate_has_digit() {
		Rule r = new RegexRule(".*\\d.*", 
			"password must consist of only upper and lower case letters and/or digits");
		assertEquals("failed to validate()", true, r.validate("1"));
	}

	@Test 
	public void testValidate_has_all_four() {
		String test="Aa1";
		Rule word  = new RegexRule("\\w+", "");
		Rule digit = new RegexRule(".*\\d.*", "");
		Rule upper = new RegexRule(".*[A-Z].*", "");
		Rule lower = new RegexRule(".*[a-z].*", "");
		assertEquals("failed to validate()", true, 
			word.validate(test) );
		assertEquals("failed to validate()", true, 
			digit.validate(test) );
		assertEquals("failed to validate()", true, 
			lower.validate(test)); 
		assertEquals("failed to validate()", true, 
			upper.validate(test));
		assertEquals("failed to validate()", true, 
			digit.validate(test) 
			&& lower.validate(test) 
			&& upper.validate(test));
	}


	@Test
	public void testGetGuidelines() {
		Rule r = new RegexRule("\\w+", 
			"password must consist of only upper and lower case letters and/or digits" );
		assertEquals("failed to match guidelines", 
			"password must consist of only upper and lower case letters and/or digits", 
			r.getGuidelines());
	}
}


