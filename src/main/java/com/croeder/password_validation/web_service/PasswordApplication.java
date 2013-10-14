package com.croeder.password_validation.web_service;

import org.glassfish.jersey.server.ResourceConfig;

public class PasswordApplication extends ResourceConfig {

	public PasswordApplication(Class klass) {
		super(klass);
		register(new PasswordApplicationBinder());
		packages(true, "com.croeder.password_validation.web_service");
	}
}
