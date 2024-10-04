package org.rygn.mvn_helloworld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbClient {

	private MongoClient mongoClient;
	
	public MongoDbClient(String host, int port) {
	
		this.mongoClient = MongoClients.create("mongodb://" + host + ":" + port);
	}
	
	public Collection<Document> findAllPosts() {
		
		Collection<Document> result = new ArrayList<>();
		
		// Accessing the database 
		MongoDatabase database = mongoClient.getDatabase("test"); 

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
