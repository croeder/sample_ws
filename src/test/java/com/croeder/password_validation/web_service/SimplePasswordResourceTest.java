package com.croeder.password_validation.web_service;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class SimplePasswordResourceTest {

    private HttpServer server;
    private WebTarget target;
	private final Logger logger = Logger.getLogger(PasswordResourceTest.class);

    @Before
    public void setUp() throws Exception {
		BasicConfigurator.configure();
		
        // start the server
		logger.debug("xxxxx passwordResourceTest");
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

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
