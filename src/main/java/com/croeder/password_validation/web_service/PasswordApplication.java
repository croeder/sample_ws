package com.croeder.password_validation.web_service;

import org.glassfish.jersey.server.ResourceConfig;
import org.apache.log4j.Logger;

public class PasswordApplication extends ResourceConfig {
	private final Logger logger = Logger.getLogger(PasswordApplication.class);

	public PasswordApplication(Class klass) {
		super(klass);
		logger.debug("PasswordApplication 1");
		register(new PasswordApplicationBinder());
		logger.debug("PasswordApplication 2");
		packages(true, "com.croeder.password_validation.web_service");
		logger.debug("PasswordApplication 3");
	}
}
