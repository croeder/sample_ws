package com.croeder.password_validation.web_service;


import com.croeder.password_validation.rules.PasswordValidator;
import com.croeder.password_validation.rules.TrueValidator;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.hk2.utilities.binding.ServiceBindingBuilder;

import org.apache.log4j.Logger;

public class PasswordApplicationBinder extends AbstractBinder {

	private final Logger logger = Logger.getLogger(PasswordApplicationBinder.class);

	@Override
	protected void configure() {
		//bind(TrueValidator.class).to(PasswordValidator.class); 
		ServiceBindingBuilder sbb = bind(TrueValidator.class);
		sbb.to(PasswordValidator.class); 
		logger.debug("PasswordApplicationBinder configure");
	}
	
}

