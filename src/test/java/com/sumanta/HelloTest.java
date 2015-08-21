package com.sumanta;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloTest {

    @InjectMocks
    Hello hello;

    MockHttpRequest request;
    MockHttpResponse response;

    Dispatcher dispatcher;

    @Before
    public void setup() {
        dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getRegistry().addSingletonResource(hello);
        response = new MockHttpResponse();
    }

    /**
     * Test method for {@link com.sumanta.Hello#HelloWorld()}.
     * 
     * @throws URISyntaxException
     */
    @Test
    public void testHelloWorld() throws URISyntaxException {
        request = MockHttpRequest.get("/hello/hello");
        dispatcher.invoke(request, response);

        assertEquals(response.getStatus(), 200);
        assertEquals("<p>hello world</p>", response.getContentAsString());
    }

    /**
     * Test method for {@link com.sumanta.Hello#xmlHello()}.
     * 
     * @throws URISyntaxException
     */
    @Test
    public void testXmlHello() throws URISyntaxException {
        request = MockHttpRequest.get("/hello/xml");
        dispatcher.invoke(request, response);

        assertEquals(response.getStatus(), 200);
        assertEquals("<?xml version=\"1.0\"?><hello> Hello Jersey</hello>", response.getContentAsString());
    }

    /**
     * Test method for {@link com.sumanta.Hello#getDeatils(int, int)}.
     * 
     * @throws URISyntaxException
     */
    @Test
    public void testGetDeatils() throws URISyntaxException {
        request = MockHttpRequest.post("/hello/got").addFormHeader("id", "3");
        dispatcher.invoke(request, response);

        assertEquals(response.getStatus(), 200);
        assertEquals("got: 3", response.getContentAsString());
    }

    /**
     * Test method for {@link com.sumanta.Hello#add(int)}.
     * 
     * @throws URISyntaxException
     */
    @Test
    public void testAdd() throws URISyntaxException {
        request = MockHttpRequest.get("/hello/add/2/3");
        dispatcher.invoke(request, response);

        assertEquals(response.getStatus(), 200);
        assertEquals("5", response.getContentAsString());
    }

}
