package com.fox.alibaba.leetcode150_6_Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-19 14:30
* @version 1.0
*/
public class Classic051_Ranges_FindMinArrows {
	public static void main(String[] args) {
		Classic051_Ranges_FindMinArrows c51 = new Classic051_Ranges_FindMinArrows();
		int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
		System.out.println(c51.findMinArrowShots(points));
		System.out.println(-2147483646-2147483646);
	}
	
	public int findMinArrowShots(int[][] points) {

        int n = points.length;
        if (n < 1)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] <= o2[0]) {
					return -1;
				}else {
					return 1;
				}
            }

        });

        int cnt = 0;

        int i = 0;
        while (i < n) {
            int high = points[i][1];
            i++;
            while (i < n && points[i][0] <= high) {
                high = high < points[i][1] ? high : points[i][1];
                i++;
            }
            cnt += 1;
        }

        return cnt;

    }
}
