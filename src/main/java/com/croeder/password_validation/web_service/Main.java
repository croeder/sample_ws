/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.web_service;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.croeder.password_validation.rules.PasswordValidator;
import com.croeder.password_validation.rules.TrueValidator;
import com.croeder.password_validation.rules.AppValidator;



/**
 * stand-alone grizzly http server with web service
 */
public class Main  {
    public static final String BASE_URI = "http://localhost:8080/password_app";
	private static final Logger logger=Logger.getLogger(Main.class);

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
		logger.debug("Main startServer");
		//final ResourceConfig config = new ResourceConfig(PasswordResource.class);
		final ResourceConfig config = new PasswordApplication(PasswordResource.class);
        config.packages("com.croeder.password_validation.web_service");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		
		logger.debug("Main main()");
	
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

