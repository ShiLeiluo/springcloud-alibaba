package com.fox.alibaba.leetcode150_08_ListNode;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-26 08:57
 * @version 1.0
 */
public class Classic062_ListNode_GroupReverse {
	public static void main(String[] args) {
		Classic062_ListNode_GroupReverse c62 = new Classic062_ListNode_GroupReverse();
		ListNode head = c62.new ListNode(1, c62.new ListNode(2, c62.new ListNode(3, c62.new ListNode(4, c62.new ListNode(5)))));
		System.out.println(c62.printListNode(head));
		System.out.println(c62.printListNode(c62.reverseKGroup(head, 2)));
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		// 设置哑巴节点
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		
		// 得到pre
		ListNode pre = dummyNode;

		boolean canReverse = true;

		while(canReverse) {
			ListNode curr = pre.next;
			ListNode next;
			for (int i = 0; i < k-1; i++) {
				next = curr.next;
				curr.next = next.next;
				next.next = pre.next;
				pre.next = next;
			}
			pre = curr;
			ListNode groupPre = pre;
			for (int i = 0; i < k; i++) {
				if (groupPre.next != null) {
					groupPre = groupPre.next;
				}else {

					canReverse = false;
					break;
				}
			}
		}
		
		return dummyNode.next;
		
	}
	
	public void revereseLinkedList(ListNode head) {
		//反转一个链表
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			
			curr.next = pre;
			pre = curr;
			curr = next;
			
		}
	}
	
	
	private String printListNode(ListNode head) {
		
		StringBuilder sb = new StringBuilder();
		ListNode curr = new ListNode(-1);
		curr.next = head;
		while (curr.next != null) {
			int val = curr.next.val;
			
			curr = curr.next;
			if (curr.next == null) {
				sb.append(val);
			}else {
				sb.append(val + ", ");
			}
			
		}
		return "[" + sb.toString() + "]";
	}

	public class ListNode {
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