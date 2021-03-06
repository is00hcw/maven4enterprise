package org.tongqing.m4enterprise.core;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ApplicationServiceTest {

    private ApplicationService applicationService;

    @Before
    public void setUp() throws Exception {
	applicationService = new ApplicationService();
    }

    @Test
    public void testSayHello() {
	assertEquals("Hello: Marcin", applicationService.sayHello("Marcin"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSayHelloWithNullName() {
	applicationService.sayHello(null);
    }
}
