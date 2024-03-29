package com.fox.alibaba.leetcode150_8_ListNode;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-27 14:02
* @version 1.0
*/
public class Classic065_ListNode_Rotate {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		int k = 0;
		
		Classic065_ListNode_Rotate c65 = new Classic065_ListNode_Rotate();
		System.out.println(c65.printListNode(head));
		System.out.println(c65.printListNode(c65.rotateRight(head, k)));
		System.out.println((4-2)%2);
	}
	
	
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		//遍历一遍, 计算节点数量
		ListNode cntNode = new ListNode(-1);
		cntNode.next = head;
		int cnt = 0;
		while(cntNode.next != null) {
			cntNode = cntNode.next;
			cnt += 1;
		}
		int cutPos = cnt - (k % cnt);
		if (cnt==1 || cutPos == cnt || k==0) {
			return head;
		}
		
		// 使其尾节点指向其头结点
		cntNode.next = head;
		
		// 算出要断开的节点
		

		ListNode curr = new ListNode(-1);
		curr.next = head;
		
		for (int i = 0; i < cutPos; i++) {
			curr = curr.next;
			
		}
		dummyNode.next = curr.next;
		curr.next = null;
		
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
