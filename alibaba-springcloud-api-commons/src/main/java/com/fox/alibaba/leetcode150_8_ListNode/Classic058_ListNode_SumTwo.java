package com.fox.alibaba.leetcode150_8_ListNode;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-21 15:16
* @version 1.0
*/
public class Classic058_ListNode_SumTwo {
	//	输入：l1 = [2,4,3], l2 = [5,6,4]
	//	输出：[7,0,8]
	//	解释：342 + 465 = 807.
	public static void main(String[] args) {
		Classic058_ListNode_SumTwo c57 = new Classic058_ListNode_SumTwo();
		
		ListNode l11 = new ListNode();
		ListNode l12 = new ListNode();
		ListNode l13 = new ListNode();
		l11.val = 2;l11.next=l12;
		l12.val = 4;l12.next=l13;
		l13.val = 3;
		ListNode l21 = new ListNode();
		ListNode l22 = new ListNode();
		ListNode l23 = new ListNode();
		l21.val = 5;l21.next=l22;
		l22.val = 6;l22.next=l23;
		l23.val = 4;
		
		ListNode res = c57.addTwoNumbers(l11, l21);
		
		System.out.println(c57.printAllListNodeVal(res));

	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		StringBuilder sb1 = new StringBuilder();
		while(l1 != null) {
			sb1.append(l1.val);
			l1 = l1.next;
		}
		StringBuilder sb2 = new StringBuilder();
		while(l2 != null) {
			sb2.append(l2.val);
			l2 = l2.next;
		}
		
		String ans = addLargeNumber(sb1.reverse().toString(), sb2.reverse().toString());
		System.out.println(ans);
		int len = ans.length();

		ListNode head = new ListNode();
		head.val = Integer.parseInt(String.valueOf(ans.charAt(len - 1)));
		ListNode nextNode = head;
		
		for (int i = len-2; i >= 0; i--) {
			ListNode listNode = new ListNode();
			int val = Integer.parseInt(String.valueOf(ans.charAt(i)));
			listNode.val = val;
			nextNode.next = listNode;
			nextNode = nextNode.next;
		}
		
		nextNode = head;
		
		
		return nextNode;
		
	}
	private String addLargeNumber(String a, String b) {

        // 数字字符串a，b的倒数索引
        int aIndex = 1;
        int bIndex = 1;
        // 进位
        int flag = 0;
        String res = "";
        while (aIndex <= a.length() || bIndex <= b.length() || flag > 0) {
            // 找到字符串倒数第 i 位上的数字
            int aNum = aIndex <= a.length() ? a.charAt(a.length() - aIndex) - '0' : 0;
            int bNum = bIndex <= b.length() ? b.charAt(b.length() - bIndex) - '0' : 0;
            // 将两个数字相加
            res = (aNum + bNum + flag) % 10 + res;
            // 判断是否进位
            flag = (aNum + bNum + flag) / 10;
            aIndex++;
            bIndex++;
        }
        return res;
    }

	private String printAllListNodeVal(ListNode listNode) {
		StringBuilder sb = new StringBuilder();
		while (listNode != null) {
			if (listNode.next == null) {
				sb.append(listNode.val);
			}else {
				sb.append(listNode.val + ", ");
			}
			
			listNode = listNode.next;
		}
		return "[" + sb.toString() + "]";
	}
}
// 可以有多个类，但只能有一个public的类，并且public的类名必须与文件名相一致。一个文件中可以只有非public类，如果只有一个非public类，此类可以跟文件名不同。
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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