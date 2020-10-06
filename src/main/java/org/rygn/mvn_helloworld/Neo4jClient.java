package org.rygn.mvn_helloworld;

import java.util.ArrayList;
import java.util.Collection;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;



public class Neo4jClient {

	private Driver neo4jDriver;
	
	public Neo4jClient(String host, int port, String user, String password) {
		
		this.neo4jDriver = GraphDatabase.driver("bolt://" + host + ":" + port, 
												AuthTokens.basic( user, password));
	}
	
	public Collection<String> findAllPersonNames() {
		
		Collection<String> result = new ArrayList<>();
		
		try (Session session = this.neo4jDriver.session()) {
			
            Result statementResult = session.run("MATCH (a:PERSON) RETURN a.firstname AS name");
            
           
            while (statementResult.hasNext()) {
                
            	Record record = statementResult.next();
                
            	result.add(record.get("name").asString());
            }
        }
		
		return result;
	}
	
	public void close() {
		
		this.neo4jDriver.close();
	}
}
