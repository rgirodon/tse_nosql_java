package org.rygn.mvn_helloworld;



import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for App.
 */
public class CassandraClientTest{

	private CassandraClient cassandraClient;
	
	@Before
	public void init() {
		
		this.cassandraClient = new CassandraClient("localhost", 9042);
	}
	
	@Test
	public void testFindAllCyclistsName() {
		
		Collection<String> names = this.cassandraClient.findAllCyclistsName();
		
		Assert.assertEquals(2, names.size());	
	}
	
	@After
	public void close() {
		
		this.cassandraClient.close();
	}
}
