package org.rygn.mvn_helloworld;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;


public class CassandraClient {

	private CqlSession session;
	
	public CassandraClient(String host, int port) {
		
		this.session = CqlSession.builder()
								    .addContactPoint(new InetSocketAddress(host, port))
								    .withLocalDatacenter("datacenter1")	
								    .withKeyspace("cycling")
								    .build();
	}
	
	public Collection<String> findAllCyclistsName() {
		
		Collection<String> result = new ArrayList<>();
			
		ResultSet rs = session.execute("select lastname FROM cyclists");
	  
		Iterator<Row> rowIterator = rs.iterator();
		
		while (rowIterator.hasNext()) {
		    
	    	Row row = rowIterator.next();
	    	
	    	result.add(row.getString("lastname"));
	    }
		
		return result;
	}
	
	public void close() {
		
		this.session.close();
	}
}
