package com.collections.lru;


public class LRUmain {

	public static void main(String[] args) {
		
		LRUCache lru = new LRUCache(3);
	   
	        lru.set(1, 10);
	        lru.set(2, 20);
	        lru.set(3, 30);
	   
	    lru.printLRUCache();
	    
	    lru.set(4, 30);
	    
	    lru.printLRUCache();
	    
	    lru.set(5, 20);
	    
	    lru.printLRUCache();
		
	}
	
	
	
}
