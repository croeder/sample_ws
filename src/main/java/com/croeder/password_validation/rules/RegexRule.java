package com.croeder.password_validation.rules;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Implements a rule to apply a regular expression to a password for validation
 * 
 * @author croeder
 */
public class RegexRule implements Rule {

	private Pattern pattern;
	private String guidelines;
	
	/**
 	 * @param patternString a string to compile as a pattern
	 *
	 */ 
	public RegexRule(String patternString, String guidelines) {
		this(Pattern.compile(patternString));
		this.guidelines = guidelines;
	}

	/**
	 * @param pattern  a compiled pattern to use
	 */
	public RegexRule(Pattern pattern) {
		this.pattern = pattern;	
	}

	/**
 	* returns true if the password is acceptable
	**/
    public boolean validate(String password) { 
		Matcher matcher = pattern.matcher(password);
		return  (matcher.matches() 
			&& matcher.start() == 0
			&& matcher.end() == (password.length()));
    }

	/**
	 * returns a general description of the rule
     */
    public String getGuidelines() {
        return  guidelines;
    }

}

