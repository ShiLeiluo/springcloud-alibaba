package com.fox.alibaba.leetcode150_06_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-18 16:31
* @version 1.0
*/
public class Classic050_Ranges_Insert {
	public static void main(String[] args) {
		Classic050_Ranges_Insert c50 = new Classic050_Ranges_Insert();
		int[][] intervals = {{3,5}, {13,15}};
		int[] newInterval = {6, 6};
//		int[][] intervals = {{1,3}, {6,9}};
//		int[] newInterval = {2, 5};
//		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//		int[] newInterval = {4, 8};
		System.out.println(Arrays.deepToString(intervals));
		System.out.println(Arrays.toString(newInterval));
//		Arrays.stream(c50.insert(intervals, newInterval)).forEach(row->System.out.println(Arrays.toString(row)));
		System.out.println(Arrays.deepToString(c50.insert(intervals, newInterval)));
		
		System.out.println("中国".length());
		
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval){
		
		int n = intervals.length;
		if (n==0) return new int[][] {newInterval};
		
		List<int[]> merge = new ArrayList<>();
		
		// 判断newInterval是否被处理
		boolean isNotInsert = true;
		
		
		//分组循环
		int i = 0;		
		while(i<n) {
			int low = intervals[i][0];
			int high = intervals[i][1];
			// newInterval不能被合并
			if (isNotInsert && newInterval[1]<low) {
				merge.add(newInterval);
				isNotInsert = false;
			}
			// newInterval能被第一个区间合并
			if (isNotInsert && newInterval[0]<=high) {
				low = low<newInterval[0]?low:newInterval[0];
				high = high>newInterval[1]?high:newInterval[1];
				isNotInsert = false;
			}
			i++;
			
			while(i<n && intervals[i][0]<=high) {
				high = high>intervals[i][1]?high:intervals[i][1];
				// // newInterval能被中间区间合并
				if (isNotInsert && newInterval[0]<=high) {
					low = low<newInterval[0]?low:newInterval[0];
					high = high>newInterval[1]?high:newInterval[1];
					isNotInsert = false;
				}
				i++;
			}
			

			merge.add(new int[] {low, high});
		}
		// 循环结束未被处理, newInterval在intervals后
		if (isNotInsert) {
			merge.add(newInterval);
		}
		return merge.toArray(new int[merge.size()][2]);
		
	}
}
