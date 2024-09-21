package com.fox.alibaba.leetcode150_16_DivideNConquer;

/**
* @author F1337248 ShiLeiluo
* @date 2024-06-13 08:26
* @version 1.0
*/
public class Classic108_DivideNConquer_SortedListNode {
	public static void main(String[] args) {
		
		
		
		Classic108_DivideNConquer_SortedListNode c108 = new Classic108_DivideNConquer_SortedListNode();
		
		ListNode head = c108.new ListNode(4,c108.new ListNode(2, c108.new ListNode(1, c108.new ListNode(3))));
		
		ListNode sortedList = c108.sortedList(head);
		
		
		ListNode dummyNode = c108.new ListNode(-1);
		dummyNode.next = sortedList;
		while (dummyNode.next != null) {
			
			dummyNode = dummyNode.next;
			System.out.println(dummyNode.val);
		}
	}
	
	public ListNode sortedList(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		
		
		
		return head;
		
	}

	public class ListNode{
		private int val;
		private ListNode next;
		
		public ListNode() {}
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
