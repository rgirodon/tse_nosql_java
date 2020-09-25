package org.rygn.mvn_helloworld;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for App.
 */
public class RedisClientTest{

	private RedisClient redisClient;
	
	@Before
	public void init() {
		
		this.redisClient = new RedisClient("localhost", 6379);
	}
	
	@Test
	public void testRedisClient_handleString() {
		
		this.redisClient.setStringKey("key_test", "value_test");
		
		Assert.assertEquals("value_test", this.redisClient.getStringKey("key_test"));

		this.redisClient.deleteStringKey("key_test");
	}
}
