/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.web_service;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

import com.croeder.password_validation.rules.PasswordValidator;

@Path("password")
public class PasswordResource {

	private PasswordValidator validator;
	private static Logger logger = Logger.getLogger(PasswordResource.class);

	@Inject
	public PasswordResource(PasswordValidator validator) {
		this.validator = validator;
	}


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/validate")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getIt(@QueryParam("password") String password) {
		logger.debug("testing password:" + password);
		logger.debug("result is: " + (validator.validate(password).getLeft()).toString()); 
		//return (validator.validate(password).getLeft()).toString(); 
		if (validator.validate(password).getLeft()) {
			ResponseBuilder builder = Response.ok("true");
			logger.debug("positive:" + builder.build().toString() );
			return builder.build();
		}
		else {
			ResponseBuilder builder = Response.status(412);
			logger.debug("negative :" + builder.build().toString() );
			return builder.build();
			
		}
    }

}
