package com.fox.alibaba.leetcode150_8_ListNode;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-22 11:04
 * @version 1.0
 */
public class Classic059_ListNode_Merge {
//	输入：list1 = [1,2,4], list2 = [1,3,4]
//	输出：[1,1,2,3,4,4]
	public static void main(String[] args) {
		Classic059_ListNode_Merge c58 = new Classic059_ListNode_Merge();
		
		ListNode list1 = c58.new ListNode(1, c58.new ListNode(2, c58.new ListNode(4))); 
		ListNode list2 = c58.new ListNode(1, c58.new ListNode(3, c58.new ListNode(4))); 
		
		System.out.println(c58.printListNode(c58.mergerTwoLists(list1, list2)));
		
		
	}
	
	public ListNode mergerTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) return null;
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		
		
		
		ListNode head = new ListNode();
		if (list1.val<list2.val) {
			head.val = list1.val;
			list1 = list1.next;
		}else {
			head.val = list2.val;
			list2 = list2.next;
		}
		System.out.println("head.val: " + head.val + ", head.next: " + head.next);
		ListNode nextNode = head;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				nextNode.next = list2;
				nextNode = nextNode.next;
				list2 = list2.next;
				continue;
			}
			if (list2 == null) {
				nextNode.next = list1;
				nextNode = nextNode.next;
				list1 = list1.next;
				continue;
			}
			if (list1.val<list2.val) {
				nextNode.next = list1;
				nextNode = nextNode.next;
				list1 = list1.next;

			}else {
				nextNode.next = list2;
				nextNode = nextNode.next;
				list2 = list2.next;

			}
			
		}
		
		nextNode = head;
		
		return nextNode;
	}
	
	
	private String printListNode(ListNode listNode) {
		StringBuilder sb = new StringBuilder();
		while (listNode != null) {
			int val = listNode.val;
			listNode = listNode.next;
			if (listNode != null) {
				sb.append(val + ",");
			}else {
				sb.append(val);
			}
			
		}
		return "[" + sb.toString() + "]";
	}
	public class ListNode {
	    int val; //默认值为0
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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