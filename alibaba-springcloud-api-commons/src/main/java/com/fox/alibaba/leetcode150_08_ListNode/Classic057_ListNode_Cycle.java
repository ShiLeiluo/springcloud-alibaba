package com.fox.alibaba.leetcode150_08_ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-21 14:21
 * @version 1.0
 */
public class Classic057_ListNode_Cycle {
	public static void main(String[] args) {
		Classic057_ListNode_Cycle c56 = new Classic057_ListNode_Cycle();

		ListNode head1 = c56.new ListNode(3);
		ListNode head2 = c56.new ListNode(2);
		ListNode head3 = c56.new ListNode(0);
		ListNode head4 = c56.new ListNode(4);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head2;
		System.out.println("hasCycle: " + c56.hasCycle(head1));
	}

	public boolean hasCycle(ListNode head) {
		Set<ListNode> seen = new HashSet<ListNode>();
		while (head != null) {
			if (!seen.add(head)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			// TODO Auto-generated constructor stub
			val = x;
			next = null;
		}
	}

}

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
