package com.fox.alibaba.leetcode150_15_BackTracking;

import java.util.HashSet;
import java.util.Set;

/**
* @author F1337248 ShiLeiluo
* @date 2024-06-04 16:22
* @version 1.0
*/
public class Classic104_BackTrack_TotalQueens {
	public static void main(String[] args) {
		Classic104_BackTrack_TotalQueens c104 = new Classic104_BackTrack_TotalQueens();
		int n = 10;

		int ans = c104.totalNQueens(n);
		
		System.out.println(ans);
	}
	
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
}
