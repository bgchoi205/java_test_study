package com.cbg.exam.app.session;

import java.util.HashMap;
import java.util.Map;

public class Session {
	
	private Map<String, Object> storage;
	
	public Session(){
		storage = new HashMap<>();
	}

	public void setAttribute(String key, Object value) {
		storage.put(key, value);
		
	}
	
	public Object getAttribute(String key) {
		return storage.get(key);
	}
	
	public void removeAttribute(String key) {
		storage.remove(key);
	}
	
	public boolean hasAttribute(String key) {
		return storage.containsKey(key);
	}

}
