package com.croeder.password_validation.web_service;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;

public class PasswordResourceTest {

    private HttpServer server;
    private WebTarget target;
	private final Logger logger = Logger.getLogger(PasswordResourceTest.class);

    @Before
    public void setUp() throws Exception {
		
        // start the server
		logger.debug("starting server");
        server = Main.startServer();
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
		logger.debug("stopping server");
        server.stop();
    }

	@Test
    public void testGetIt_positive() {
        Response response = target.path("password/validate").queryParam("password", "aA1xx").request().get();
        logger.debug("RESPONSE: (positive?) " + response.toString());
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testGetIt_negative() {
        Response response = target.path("password/validate").queryParam("password", "bad").request().get();
        logger.debug("RESPONSE: (negative?)" + response.toString());
        assertEquals(412, response.getStatus());
    }

}
