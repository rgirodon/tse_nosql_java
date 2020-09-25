package org.rygn.mvn_helloworld;


import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for App.
 */
public class Neo4jClientTest{

	private Neo4jClient neo4jClient;
	
	@Before
	public void init() {
		
		this.neo4jClient = new Neo4jClient("127.0.0.1", 7687, "neo4j", "rgirodon");
	}
	
	@Test
	public void testFindAllPersonNames() {
		
		Collection<String> names = this.neo4jClient.findAllPersonNames();
		
		Assert.assertEquals(3, names.size());
		
		Assert.assertTrue(names.contains("Remy"));
		
		Assert.assertTrue(names.contains("Jacques"));
		
		Assert.assertTrue(names.contains("Bruno"));
	}
	
	@After
	public void close() {
		
		this.neo4jClient.close();
	}
}
