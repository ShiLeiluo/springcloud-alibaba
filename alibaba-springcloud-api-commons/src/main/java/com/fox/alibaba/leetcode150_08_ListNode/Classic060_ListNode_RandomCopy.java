package com.fox.alibaba.leetcode150_08_ListNode;

import java.util.HashMap;
import java.util.Map;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-25 09:49
* @version 1.0
*/
public class Classic060_ListNode_RandomCopy {
	public static void main(String[] args) {
		Classic060_ListNode_RandomCopy c60 = new Classic060_ListNode_RandomCopy();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		n1.next = n2;
		n1.random = n2;
		n2.random = n2;
		
		Node res = c60.copyRandomList(n1);
		System.out.println(res.random.val);
	}

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/