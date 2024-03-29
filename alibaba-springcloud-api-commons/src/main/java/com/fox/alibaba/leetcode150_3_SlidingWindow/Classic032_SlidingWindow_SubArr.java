package com.fox.alibaba.leetcode150_3_SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-07 15:48
 * @version 1.0
 */
public class Classic032_SlidingWindow_SubArr {

	public List<Integer> findSubstring(String s, String[] words) {
		int n = s.length(), m = words.length, w = words[0].length();
		// 统计 words 中「每个目标单词」的出现次数
		Map<String, Integer> map = new HashMap<>();
		for (String str : words)
			//map.getOrDefault(str, 0) + 1 
            //可以使用getOrDefault方法安全地获取一个键的值，而不必担心键不存在时抛出异常。
			map.put(str, map.getOrDefault(str, 0) + 1);
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < w; i++) {
			// 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
			Map<String, Integer> temp = new HashMap<>();
			// 滑动窗口的大小固定是 m * w，每次将下一个单词添加进 temp，上一个单词移出 temp
			for (int j = i; j + w <= n; j += w) {
				String cur = s.substring(j, j + w);
				temp.put(cur, temp.getOrDefault(cur, 0) + 1);
				if (j >= i + (m * w)) {
					int idx = j - m * w;
					String prev = s.substring(idx, idx + w);
					if (temp.get(prev) == 1)
						temp.remove(prev);
					else
						temp.put(prev, temp.get(prev) - 1);
					if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0)))
						continue;
				}
				if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0)))
					continue;
				// 上面两个 continue 可以减少 map 之间的 equals 操作
				if (temp.equals(map))
					ans.add(j - (m - 1) * w);
			}
		}
		return ans;
	}
}
