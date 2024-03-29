package com.fox.alibaba.leetcode150_4_Matrix;

import java.util.Arrays;
import java.util.HashSet;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-13 08:16
* @version 1.0
*/
public class Classic037_Matrix_SetZeros {
	public static void main(String[] args) {
		Classic037_Matrix_SetZeros c37 = new Classic037_Matrix_SetZeros();
		int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		c37.setZeros(matrix);
		
		Arrays.stream(matrix).forEach(row->System.out.println(Arrays.toString(row)));
	}
	
	public void setZeros(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		HashSet<Integer> rowSet = new HashSet<>();
		HashSet<Integer> colSet = new HashSet<>();
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
				
			}
		}
		for (Integer integer : colSet) {
			System.out.println(integer);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rowSet.contains(i) || colSet.contains(j)) {
					matrix[i][j] = 0;
				}
				
			}
		}
	}
}
