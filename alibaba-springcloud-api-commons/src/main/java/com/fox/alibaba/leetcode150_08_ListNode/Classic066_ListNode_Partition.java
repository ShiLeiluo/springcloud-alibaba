package com.fox.alibaba.leetcode150_08_ListNode;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-28 09:10
* @version 1.0
*/
public class Classic066_ListNode_Partition {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);ListNode l4 = new ListNode(0);
		ListNode l5 = new ListNode(2);ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(2);
		l1.next = l2;l2.next = l3;l3.next = l4;
		l4.next = l5;l5.next = l6;l6.next = l7;
		int x = 3;
		
		Classic066_ListNode_Partition c66 = new Classic066_ListNode_Partition();
		System.out.println(c66.printListNode(l1));

		System.out.println(c66.printListNode(c66.partition(l1, x)));
	}
	
	
	public ListNode partition(ListNode head, int x) {
		
		if (head == null) return null;
		
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next= head;
		
		ListNode left = new ListNode(-1);
		left = dummyNode;
		while(left.next != null) {
			if (left.next.val >= x) {
				break;
			}
			left = left.next;
		}
		
		if (left.next == null) {
			return dummyNode.next;
		}
		
		ListNode right = new ListNode(-1);
		right = left.next;
		left.next = null;
		
		ListNode iter = new ListNode(-1);
		
		iter = right;
		System.out.println(printListNode(left) + ", " + printListNode(right));
		
		while(iter.next != null) {
			if (iter.next.val >= x) {
				iter = iter.next;
			}else {
				ListNode curr = new ListNode(-1);
				curr = iter.next;
				if (curr.next != null) {
					iter.next = curr.next;

				}else {
					iter.next = null;
				}
				left.next = curr;
				left = left.next;
				left.next = null;
			}
			System.out.println(printListNode(dummyNode.next) + ", " + printListNode(right));
			
		}
		left.next = right;
		return dummyNode.next;
		
		
	}
	
	private String printListNode(ListNode head) {
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		
		StringBuilder sb = new StringBuilder();
		
		while(dummyNode.next != null) {

			dummyNode = dummyNode.next;
			int val = dummyNode.val;
			if(dummyNode.next != null) {
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
