/**
 * Copyright 2013 Chris Roeder
 */
package com.croeder.password_validation.web_service;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SimplePasswordResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
		
        server = Main.startServer();

        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the correct message is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("simplepassword/aA1xx").request().get(String.class);
        assertEquals("true", responseMsg);
    }
}
