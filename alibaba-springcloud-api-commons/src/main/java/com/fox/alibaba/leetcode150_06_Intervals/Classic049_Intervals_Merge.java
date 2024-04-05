package com.fox.alibaba.leetcode150_06_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-18 10:17
* @version 1.0
*/
public class Classic049_Intervals_Merge {
	public static void main(String[] args) {
		Classic049_Intervals_Merge c49 = new Classic049_Intervals_Merge();
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; 
//		int[][] intervals = {{1,4},{0,2},{3,5}}; 
		System.out.println(Arrays.deepToString(intervals));
		System.out.println("merge: ");
		Arrays.stream(c49.merge(intervals)).forEach(row->System.out.println(Arrays.toString(row)));
	}
	
	// 先排序, 然后分组循环
	public int[][] merge(int[][] intervals){
		int n = intervals.length;
		List<int[]> ansList = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		int i = 0;
		while(i<n) {
			int low = intervals[i][0];
			int high = intervals[i][1];
			i++;
			while(i<n && intervals[i][0]<=high) {
				
				low = low<intervals[i][0]?low:intervals[i][0];
				high = high<intervals[i][1]?intervals[i][1]:high;
				i++;
			}

			ansList.add(new int[] {low, high});
		}
		int size = ansList.size();
		int[][] res = new int[size][2];
		for (int j = 0; j < ansList.size(); j++) {

			res[j] =  ansList.get(j);
		}
		
		return res;
		
	}
}
