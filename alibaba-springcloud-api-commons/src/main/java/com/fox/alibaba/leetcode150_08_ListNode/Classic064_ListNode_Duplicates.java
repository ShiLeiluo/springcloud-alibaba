package com.fox.alibaba.leetcode150_08_ListNode;

import java.util.HashMap;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-27 10:08
* @version 1.0
*/
public class Classic064_ListNode_Duplicates {
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(5);
		l1.next = l2;l2.next = l3;
		l3.next = l4;l4.next = l5;
		l5.next = l6;l6.next = l7;
		Classic064_ListNode_Duplicates c64 = new Classic064_ListNode_Duplicates();
		System.out.println(c64.printListNode(l1));
		
		System.out.println(c64.printListNode(c64.deleteDuplicates(l1)));
		
		ListNode l11 = new ListNode(1);
		ListNode l22 = new ListNode(1);

		l11.next = l22;
		Classic064_ListNode_Duplicates c642 = new Classic064_ListNode_Duplicates();
		System.out.println(c642.printListNode(l11));
		
		System.out.println(c642.printListNode(c642.deleteDuplicates(l11)));
		
	}

	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode dummNode = new ListNode(-1);
		dummNode.next = head;
		
		ListNode cnt = dummNode;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		while (cnt.next != null) {
			cnt = cnt.next;
			map.compute(cnt.val, (k, v) -> {return v==null?1:v+1;});
			
		}
//		map.keySet().stream().forEach((key)->{System.out.println(key+", "+map.get(key));});
		ListNode pre = dummNode;
		while (pre.next != null) {
			ListNode curr = pre.next;
			while (map.get(curr.val) > 1) {

				curr = curr.next;
				if (curr == null) {
					break;
				}
			}
			pre.next = curr;
			if (pre.next != null) {
				pre = pre.next;
			}
			
		}
		
		return dummNode.next;
		
	}
	
	private String printListNode(ListNode head) {
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		
		StringBuilder sb = new StringBuilder();
		while(dummyNode.next != null) {
			
			dummyNode = dummyNode.next;
			int val = dummyNode.val;
			if (dummyNode.next != null) {
				sb.append(val + ", ");
			}else {
				sb.append(val);
			}
		}
		return "[" + sb.toString() + "]";
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int val){
			this.val = val;
		}
		ListNode(int val, ListNode next){
			this.val = val;
			this.next = next;
		}
		
		
	}
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */