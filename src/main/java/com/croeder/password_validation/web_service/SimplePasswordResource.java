package com.croeder.password_validation.web_service;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.croeder.password_validation.rules.PasswordValidator;
import com.croeder.password_validation.rules.TrueValidator;
import com.croeder.password_validation.rules.AppValidator;

@Path("simplepassword")
public class SimplePasswordResource {

	//private PasswordValidator validator=new TrueValidator();
	private PasswordValidator validator=new AppValidator();


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/{password:\\w+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("password") String password) {
		if (validator.validate(password).getLeft()) {
        	return "true";
		} 
		else {
        	return "false";
		}
			
    }
}
