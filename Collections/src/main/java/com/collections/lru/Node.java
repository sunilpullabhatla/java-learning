package com.collections.lru;

/**
 * Simple Node with Key & value
 * 
 * @author Sunil Pavan
 *
 */
public class Node{
    int key;
    String value;
    Node pre;
    Node next;
 
    public Node(int key, String value){
        this.key = key;
        this.value = value;
    }
}