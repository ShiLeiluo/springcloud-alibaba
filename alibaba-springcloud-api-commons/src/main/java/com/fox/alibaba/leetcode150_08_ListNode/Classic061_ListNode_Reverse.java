package com.fox.alibaba.leetcode150_08_ListNode;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-25 10:24
 * @version 1.0
 */
public class Classic061_ListNode_Reverse {
	public static void main(String[] args) {
		Classic061_ListNode_Reverse c61 = new Classic061_ListNode_Reverse();
		ListNode head = c61.new ListNode(1, c61.new ListNode(2, c61.new ListNode(3, c61.new ListNode(4, c61.new ListNode(5)))));
		int left = 2, right = 4;
		System.out.println(c61.printListNode(head));
		c61.reverseLinkedList(head);
		System.out.println(c61.printListNode(head));
		System.out.println("翻转: " + left +", " + right );
		System.out.println(c61.printListNode(c61.reverseBetween(head, left, right)));
	}
	public ListNode reverseBetween(ListNode head, int left, int right) {
		
		//设置哑巴节点(-1)
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		//按顺序走到left的前一个节点
		ListNode pre = dummyNode;
		for (int i = 0; i < left-1; i++) {
			pre = pre.next;
		}
		
		ListNode curr = pre.next;
		ListNode next;
		for (int i = 0; i < right - left; i++) {
			next = curr.next;
			curr.next = next.next;
			next.next = pre.next;
			pre.next = next;
		}
		
		return dummyNode.next;
		
	}
	private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */