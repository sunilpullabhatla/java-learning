package com.collections.lru;

import java.util.HashMap;

/**
 * Least Recently Used (LRU) Data Structure was Implemented
 * 
 * @author Sunil Pavan
 *
 */

public class LRUCache {
    // Capacity of LRUCache
    private int capacity;
    // Current size of LRUCache
    private int currentSize; 
 
    // To represent Node of DoublyLinkedList
    class DoublyLinkedListNode {
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        int key;
        int value;
 
        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
 
    // First node of DoublyLinkedList
    private DoublyLinkedListNode start;
    // Last node of DoublyLinkedList
    private DoublyLinkedListNode end;
    // Map for key and DoublyLinkedList node mapping
    private HashMap<Integer, DoublyLinkedListNode> nodeMap;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        nodeMap = new HashMap<Integer, DoublyLinkedListNode>();
    }
 
    /* To print all current items in LRUCache */
    public void printLRUCache() {
        DoublyLinkedListNode traverseNode = start;
        while (traverseNode != null) {
            System.out.print(" value "
                    + traverseNode.value + " ");
            traverseNode = traverseNode.next;
        }
        System.out.println();
    }
 
    /* To add item in LRUCache */
    public void set(int key, int value) {
        if (nodeMap.containsKey(key)) {
            DoublyLinkedListNode node = nodeMap.get(key);
            node.value = value;
            bringToFront(node);
        } else {
            DoublyLinkedListNode insertNode = new DoublyLinkedListNode(key,
                    value);
            if (currentSize < capacity) {
                addToFront(insertNode);
                currentSize++;
            } else {
                removeLastNode();
                addToFront(insertNode);
            }
        }
    }
 
    /* To get item value in LRUCache */
    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            DoublyLinkedListNode node = nodeMap.get(key);
            bringToFront(node);
            return node.value;
        } else {
            return -1;
        }
    }
 
    /* To remove last node from queue */
    private void removeLastNode() {
        DoublyLinkedListNode lastNode = nodeMap.remove(end.key);
        end = end.prev;
        if (end != null)
            end.next = null;
        lastNode = null; // make it eligible for GC
    }
 
    /* To add node in front of queue */
    private void addToFront(DoublyLinkedListNode insertNode) {
        insertNode.next = start;
        insertNode.prev = null;
        if (start != null)
            start.prev = insertNode;
        start = insertNode;
        if (end == null)
            end = insertNode;
        nodeMap.put(insertNode.key, insertNode);
    }
 
    /* To reorder existing node to front of queue */
    private void bringToFront(DoublyLinkedListNode node) {
        // detach node from list
        DoublyLinkedListNode prevNode = node.prev;
        DoublyLinkedListNode nextNode = node.next;
        // handle next node
        if (prevNode != null)
            prevNode.next = nextNode;
        else
            start = nextNode;
        // hanlde prev node
        if (nextNode != null)
            nextNode.prev = prevNode;
        else
            end = prevNode;
        // add to front of ist
        addToFront(node);
    }
}