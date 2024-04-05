package com.fox.alibaba.leetcode150_05_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-15 11:23
 * @version 1.0
 */
public class Classic043_Hash_GroupAnagram {
	public static void main(String[] args) {
		Classic043_Hash_GroupAnagram c43 = new Classic043_Hash_GroupAnagram();

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(c43.groupAnagrams(strs));

		HashMap<Integer, Integer> map = new HashMap<>();
		map.computeIfAbsent(1, v -> 1);
		System.out.println("map.entrySet().stream.forEach()遍历—Stream流遍历");
		map.entrySet().stream().forEach((Map.Entry<Integer, Integer> entry) -> {
			System.out.print(entry.getKey() + ":");
			System.out.println(entry.getValue());
		});
		System.out.println("map.keySet().stream.forEach()遍历—Stream流遍历");
		map.keySet().stream().forEach(key -> {
			System.out.println(key+"-"+map.get(key));
		});
		
		map.compute(1, (k,v)->v+1);
		map.keySet().stream().forEach(key -> {
			System.out.println(key+"-"+map.get(key));
		});
		map.computeIfAbsent(1, v->3);
		map.keySet().stream().forEach(key -> {
			System.out.println(key+"-"+map.get(key));
		});
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			//存在返回List<String>, 然后.add()
			//不存在 map put(k, new ArrayList<>()), 然后然后.add()
			map.computeIfAbsent(new String(c), a -> new ArrayList<>()).add(strs[i]);
		}
		return new ArrayList<>(map.values());
	}
}
