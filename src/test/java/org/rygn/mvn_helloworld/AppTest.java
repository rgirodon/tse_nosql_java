package org.rygn.mvn_helloworld;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for App.
 */
public class AppTest{

	private App app;
	
	@Before
	public void init() {
		
		this.app = new App();
	}
	
	@Test
	public void testApp() {
		
		Assert.assertEquals(12, this.app.sum(5, 7));
		
		Assert.assertEquals(14, this.app.sum(0, 14));
	}
}
