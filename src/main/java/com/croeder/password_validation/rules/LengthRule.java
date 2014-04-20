/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.rules;


/**
 * Implements a length rule requiring a minimum and maximum length on submitted passwords.
 * 
 * @author croeder
 */
public class LengthRule implements Rule {

	private final int maxMaximumLength=100;

	private int minimumLength;
	private int maximumLength;

	/**
 	 * @param minimumLength the minimum required length to use
	 *
	 */ 
	public LengthRule(int minimumLength, int maximumLength) {
		if (   minimumLength <= 0 
			|| minimumLength > maximumLength 
			|| maximumLength > maxMaximumLength	) {
			throw new IllegalArgumentException("illegal lengths: min:" 
				+ minimumLength + " max:" + maximumLength);
		}
		this.minimumLength = minimumLength;
		this.maximumLength = maximumLength;
	}

	/**
 	* returns true if the password is acceptable
	**/
    public boolean validate(String password) { 
        return password.length() >= minimumLength 
			&& password.length() <= maximumLength; 
    }

	/**
	 * returns a general description of the rule
     */
    public String getGuidelines() {
        return "password must be at least " 
			+ minimumLength + " character(s) long,"
			+ " and shorter than " + maximumLength;
    }

}

