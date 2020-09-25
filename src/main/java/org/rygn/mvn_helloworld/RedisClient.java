package org.rygn.mvn_helloworld;

import redis.clients.jedis.Jedis;

public class RedisClient {

	private Jedis jedis;
	
	public RedisClient(String host, int port) {
		
		this.jedis = new Jedis(host, port);
	}
	
	public String getStringKey(String key) {
		
		return this.jedis.get(key);
	}
	
	public String setStringKey(String key, String value) {
		
		return this.jedis.set(key, value);
	}
	
	public void deleteStringKey(String key) {

		this.jedis.del(key);
	}
}
