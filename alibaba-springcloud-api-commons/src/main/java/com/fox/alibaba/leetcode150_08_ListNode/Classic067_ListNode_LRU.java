package com.fox.alibaba.leetcode150_08_ListNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-28 09:10
* @version 1.0
*/
public class Classic067_ListNode_LRU {
	public static void main(String[] args) {
		Classic067_ListNode_LRU c67 = new Classic067_ListNode_LRU(2);
		c67.get(2);   
		c67.put(2, 6); 
		
		c67.get(2);   
		c67.put(1, 5); 
		map.keySet().stream().forEach(k->System.out.println("["+k+", "+map.get(k)+"]"));
		System.out.println("--------------");
		c67.put(1, 2); 
		map.keySet().stream().forEach(k->System.out.println("["+k+", "+map.get(k)+"]"));
	}

	private static HashMap<Integer, Integer> map = null;
	private static LinkedList<Integer> linkedList = null;
	private static int SIZE = 0;
	
	
    public Classic067_ListNode_LRU(int capacity) {
    	map = new HashMap<>(capacity); 
    	linkedList = new LinkedList<Integer>();
    	SIZE = capacity;
    }
    
    public int get(int key) {
    	int val = -1;
    	if (linkedList.contains(key)) {
    		val = map.get(key);
    		linkedList.remove(Integer.valueOf(key));
    		linkedList.offerLast(key);
		}

		return val;
    }
    
    public void put(int key, int value) {
    	
    	if (linkedList.contains(key)) {
    		linkedList.remove(Integer.valueOf(key));
    		linkedList.offerLast(key);
    		
		}else {
			if (linkedList.size() < SIZE) {
				linkedList.offerLast(key);
				
			}else {
				Integer removeFirst = linkedList.removeFirst();
				linkedList.offerLast(key);
				map.remove(removeFirst);
			}
		}
    	map.put(key, value);
    	
    }
	

}
