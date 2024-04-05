package com.fox.alibaba.leetcode150_05_Hash;

import java.util.HashSet;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-15 13:56
* @version 1.0
*/
public class Classic045_Hash_Happy {
	
	public static void main(String[] args) {
		Classic045_Hash_Happy c45 = new Classic045_Hash_Happy();
		int n = 19;
		System.out.println(n+"是快乐数吗?");
		System.out.println(c45.isHappy1(19));
	}
	
    // 快慢指针法, 1的平方还是1, 追上的时候都等于1
	// 不是快乐数, 在循环中相遇.
	public boolean isHappy(int n) {
		
		int slowPoint = getNext(n);
		int fastPoint = getNext(getNext(n));
		while (fastPoint != 1 && fastPoint != slowPoint) {
			slowPoint = getNext(slowPoint);
			fastPoint = getNext(getNext(fastPoint));
		}
		
		return fastPoint == 1;
		
	}
	// 转了一个圈, 就不是快乐数
	public boolean isHappy1(int n) {
		
		HashSet<Integer> nums = new HashSet<>();
		int res = getNext(n);
		while (res != 1) {
			
			res = getNext(res);
			if (nums.contains(res)) {
				return false;
			}
			nums.add(res);
		}
		
		return true;
		
	}
	
	private int getNext(int n) {
		
		int res = 0;
		while (n > 0) {
			int d = n % 10;
			n = n/10;
			
			res += Math.pow(d, 2);
		}
		
		return res;
		
	}
}
