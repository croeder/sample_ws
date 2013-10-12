package com.croeder.password_validator.rules;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.regex.PatternSyntaxException;


/**
 * makes sure we can use this to satisfy the app's requirements:
 * <ul>
 * <li>only word characters</li>
 * <li>one of each of upper, lower and digit characters</li>
 * <li>between 5 and 12 characters</li>
 * 
 */
public class CombinedRuleTest {

	private void runTest(String test, boolean expected) {
		Rule word  = new RegexRule("\\w+", "");
		Rule digit = new RegexRule(".*\\d.*", "");
		Rule upper = new RegexRule(".*[A-Z].*", "");
		Rule lower = new RegexRule(".*[a-z].*", "");
		Rule length = new LengthRule(5,12);

		assertEquals("failed to validate()", expected, 
			digit.validate(test) 
			&& lower.validate(test) 
			&& upper.validate(test)
			&& word.validate(test)
			&& length.validate(test));
	}

	@Test public void test_good_short() {
		runTest("xAa1x", true);
	}
	@Test public void test_good_long() {
		runTest("xAa1xxAa1xyz", true);
	}
	@Test public void test_no_upper() {
		runTest("xaa1x", false);
	}
	@Test public void test_no_digit() {
		runTest("xAaax", false);
	}
	@Test public void test_no_lower() {
		runTest("XA1AAX", false);
	}
	@Test public void test_too_short() {
		runTest("x1A", false);
	}
	@Test public void test_too_long() {
		runTest("x1Axxxxxxxxxxxx", false);
	}


}


