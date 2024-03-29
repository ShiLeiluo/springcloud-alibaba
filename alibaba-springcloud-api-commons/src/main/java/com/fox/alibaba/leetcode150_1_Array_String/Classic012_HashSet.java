package com.fox.alibaba.leetcode150_1_Array_String;

import java.util.HashSet;
import java.util.Set;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-05 09:00
* @version 1.0
*/
public class Classic012_HashSet {
	public static void main(String[] args) {
		
		Classic012_HashSet c93 = new Classic012_HashSet();
		
//		输入
//		["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//		[[], [1], [2], [2], [], [1], [2], []]
//		输出
//		[null, true, false, true, 2, true, false, 2]
		
		System.out.println(c93.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
		System.out.println(c93.remove(2)); // 返回 false ，表示集合中不存在 2 。
		System.out.println(c93.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
		System.out.println(c93.getRandom()); // getRandom 应随机返回 1 或 2 。
		System.out.println(c93.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
		System.out.println(c93.insert(2)); // 2 已在集合中，所以返回 false 。
		System.out.println(c93.getRandom()); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
	}
    Set<Integer> set;
    public Classic012_HashSet() {
        set=new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return (int) set.toArray()[(int) (Math.random() * set.size())];
    }
}
