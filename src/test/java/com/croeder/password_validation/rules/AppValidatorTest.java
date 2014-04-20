/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
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


public class AppValidatorTest {

	AppValidator av = new AppValidator();

	@Test public void test_good_short() {
		assertTrue(av.validate("xAa1x").getLeft());
	}
	@Test public void test_good_long() {
		assertTrue(av.validate("xAa1xxAa1xyz").getLeft());
	}
	@Test public void test_no_upper() {
		assertFalse(av.validate("xaa1x").getLeft());
	}
	@Test public void test_no_digit() {
		assertFalse(av.validate("xAaax").getLeft());
	}
	@Test public void test_no_lower() {
		assertFalse(av.validate("XA1AAX").getLeft());
	}
	@Test public void test_too_short() {
		assertFalse(av.validate("x1A").getLeft());
	}
	@Test public void test_too_long() {
		assertFalse(av.validate("x1Axxxxxxxxxxxx").getLeft());
	}


}



