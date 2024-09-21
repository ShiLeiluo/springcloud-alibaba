package com.fox.alibaba.leetcode150_16_DivideNConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-06-17 08:23
 * @version 1.0
 */
public class Classic108_DivideNConquer_SortedListNodeCollection {
	public static void main(String[] args) {
		Classic108_DivideNConquer_SortedListNodeCollection c108 = new Classic108_DivideNConquer_SortedListNodeCollection();
		ListNode head = c108.new ListNode(4, c108.new ListNode(2, c108.new ListNode(1, c108.new ListNode(3))));

		System.out.println("处理前: ");
		ListNode dummyNode = c108.new ListNode(-1);

		dummyNode.next = head;

		while (dummyNode.next != null) {
			dummyNode = dummyNode.next;
			System.out.println(dummyNode.val);

		}

		System.out.println("处理后: ");
		ListNode sortedList = c108.sortList2(head);
		dummyNode = c108.new ListNode(-1);

		dummyNode.next = sortedList;

		while (dummyNode.next != null) {
			dummyNode = dummyNode.next;
			System.out.println(dummyNode.val);

		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(head.val);
		ListNode cur = head.next;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		List<Object> objectList = list.stream().sorted()
				.map((Function<Integer, Object>) integer -> new ListNode(integer)).collect(Collectors.toList());
		for (int i = 0; i < objectList.size(); i++) {
			ListNode o = (ListNode) objectList.get(i);
			if (i != objectList.size() - 1) {
				o.next = (ListNode) objectList.get(i + 1);
			} else {
				o.next = null;
			}
		}
		return (ListNode) objectList.get(0); 
	}

	public ListNode sortList2(ListNode head) {
		if (head == null || head.next == null)// 这个条件哪来的，我的想法是不能让fast.next为空
			return head;
		ListNode fast = head, slow = head;
		// 偶数个节点找到中心左边的节点，好让slow.next=null，分成两段链表
		// 记住这个判断条件，偶数结点会找靠左结点，奇数就是中间节点，能用到很多题上
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode next = slow.next;
		slow.next = null;
		ListNode left = sortList2(head);
		ListNode right = sortList2(next);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) { // 两个链表merge模板，用到的地方也很多
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (left != null && right != null) {
			if (left.val > right.val) {
				cur.next = right;
				right = right.next;
			} else {
				cur.next = left;
				left = left.next;
			}
			cur = cur.next;
		}
		cur.next = left != null ? left : right;
		return dummy.next;
	}

	public class ListNode {
		private int val;
		private ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next; 
		}
	}
}
