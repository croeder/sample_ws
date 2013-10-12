package com.croeder.password_validator.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthRuleTest {

	@Test 
	public void testValidate_tooShort() {
		Rule r = new LengthRule(10);
		assertEquals("failed to validate()", false, r.validate(""));
	}

	@Test 
	public void testValidate_justRight() {
		Rule r = new LengthRule(10);
		assertEquals("failed to validate()", false, r.validate("abc"));
	}
	@Test 
	public void testValidate_tooLong() {
		Rule r = new LengthRule(10);
		assertEquals("failed to validate()", false, 
			r.validate("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"));
	}
	
	@Test
	public void testGetGuidelines() {
		Rule r = new LengthRule(10);
		assertEquals("failed to match guidelines", 
			"password must be at least 10 character(s) long, and shorter than 100", 
			r.getGuidelines());
	}
	
	@Test
	public void testGetCritique() {
		Rule r = new LengthRule(10);
		assertEquals("failed to critique properly", 
			"Make your password longer by adding at least 10characters. ", 
			r.getCritique(""));
	}

}


