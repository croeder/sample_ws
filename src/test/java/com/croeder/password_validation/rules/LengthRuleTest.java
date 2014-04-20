/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LengthRuleTest {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor() {
		Rule r = new LengthRule(-1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() {
		Rule r = new LengthRule(0, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3() {
		Rule r = new LengthRule(7, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor4() {
		Rule r = new LengthRule(7, 200);
	}

	@Test 
	public void testValidate_tooShort() {
		Rule r = new LengthRule(5, 12);
		assertEquals("failed to validate()", false, r.validate(""));
	}

	@Test 
	public void testValidate_justRight() {
		Rule r = new LengthRule(5, 12);
		assertEquals("failed to validate()", true, r.validate("abcde"));
	}

	@Test 
	public void testValidate_justRight2() {
		Rule r = new LengthRule(5, 12);
		assertEquals("failed to validate()", true, r.validate("abcdefghijkl"));
	}

	@Test 
	public void testValidate_tooLong() {
		Rule r = new LengthRule(5, 12);
		assertEquals("failed to validate()", false, 
			r.validate("1234567890123"));
	}
	
	@Test
	public void testGetGuidelines() {
		Rule r = new LengthRule(5, 12);
		assertEquals("failed to match guidelines", 
			"password must be at least 5 character(s) long, and shorter than 12", 
			r.getGuidelines());
	}
	
}


