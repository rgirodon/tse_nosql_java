package org.rygn.mvn_helloworld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraClient {

	private Cluster cluster;
	
	public CassandraClient(String host, int port) {
		
		this.cluster = Cluster.builder()
		        .withClusterName("myCluster")
		        .addContactPoint(host)
		        .withPort(port)
		        .build();
	}
	
	public Collection<String> findAllCyclistsName() {
		
		Collection<String> result = new ArrayList<>();
		
		Session session = cluster.connect("cycling");                                           

	    ResultSet rs = session.execute("select lastname FROM cyclists");    
	    
	    Iterator<Row> rowIterator = rs.iterator();
	    
	    while (rowIterator.hasNext()) {
	    
	    	Row row = rowIterator.next();
	    	
	    	result.add(row.getString("lastname"));
	    }
		
		return result;
	}
	
	public void close() {
		
		this.cluster.close();
	}
}
