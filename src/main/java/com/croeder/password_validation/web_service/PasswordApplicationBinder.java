package com.croeder.password_validation.web_service;


import com.croeder.password_validation.rules.PasswordValidator;
//import com.croeder.password_validation.rules.TrueValidator;
import com.croeder.password_validation.rules.AppValidator;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.hk2.utilities.binding.ServiceBindingBuilder;

public class PasswordApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		//bind(TrueValidator.class).to(PasswordValidator.class); 
		ServiceBindingBuilder sbb = bind(AppValidator.class);
		sbb.to(PasswordValidator.class); 
	}
	
}

