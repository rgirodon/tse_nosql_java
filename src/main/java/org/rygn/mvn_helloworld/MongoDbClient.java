package org.rygn.mvn_helloworld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbClient {

	private MongoClient mongoClient;
	
	public MongoDbClient(String host, int port) {
	
		this.mongoClient = new MongoClient(host, port);
	}
	
	public Collection<Document> findAllPosts() {
		
		Collection<Document> result = new ArrayList<>();
		
		// Accessing the database 
		MongoDatabase database = mongoClient.getDatabase("myDb"); 

	    // Retrieving a collection 
	    MongoCollection<Document> posts = database.getCollection("posts");
		
	    // Getting the iterable object
	    FindIterable<Document> iterPost = posts.find(); 
	    
	    Iterator<Document> iterator = iterPost.iterator();

	    while (iterator.hasNext()) {  
	    
	    	result.add(iterator.next());  
	    }  
	    
		return result;
	}
}
