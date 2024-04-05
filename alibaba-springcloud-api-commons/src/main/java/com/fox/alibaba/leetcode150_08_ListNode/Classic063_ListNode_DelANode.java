package com.fox.alibaba.leetcode150_08_ListNode;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-26 16:59
 * @version 1.0
 */
public class Classic063_ListNode_DelANode {
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		int n = 2;
		printListNode(head);
		
		Classic063_ListNode_DelANode c63 = new Classic063_ListNode_DelANode();
		
		printListNode(c63.removeNthFromEnd(head, n));
	}
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		int sz = 0;
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode cnt = dummyNode.next;
		while(cnt != null) {
			cnt = cnt.next;
			sz++;
		}
		
		int skipNode = sz - n;

		ListNode pre = dummyNode;
		pre = dummyNode;
		
		for (int i = 0; i < skipNode; i++) {
			pre = pre.next;
		}
		pre.next = pre.next.next;
		
		return dummyNode.next;
		
	}
	

	private static void printListNode(ListNode listNode) {
		StringBuilder sb = new StringBuilder();
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = listNode;
		
		while (dummyNode.next != null) {
			dummyNode = dummyNode.next;
			int val = dummyNode.val;
			
			if (dummyNode.next == null) {
				sb.append(val);
			}else {
				sb.append(val + ", ");
			}
			
		}
		System.out.println("[" + sb.toString() + "]");
	}
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */