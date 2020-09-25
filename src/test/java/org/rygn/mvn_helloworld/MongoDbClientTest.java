package org.rygn.mvn_helloworld;


import java.util.Collection;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for App.
 */
public class MongoDbClientTest{

	private MongoDbClient mongoDbClient;
	
	@Before
	public void init() {
		
		this.mongoDbClient = new MongoDbClient("localhost", 27017);
	}
	
	@Test
	public void testMongoDbClient() {
		
		Collection<Document> posts = this.mongoDbClient.findAllPosts();
		
		Assert.assertEquals(4, posts.size());
	}
}
