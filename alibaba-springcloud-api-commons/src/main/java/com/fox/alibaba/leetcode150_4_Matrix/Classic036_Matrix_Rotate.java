package com.fox.alibaba.leetcode150_4_Matrix;

import java.util.Arrays;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-12 10:06
 * @version 1.0
 */
public class Classic036_Matrix_Rotate {
	public static void main(String[] args) {
		Classic036_Matrix_Rotate c36 = new Classic036_Matrix_Rotate();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // [[7,4,1],[8,5,2],[9,6,3]]
		Arrays.stream(matrix).forEach((a)->System.out.println(Arrays.toString(a)));
		c36.rotate(matrix);
		System.out.println("-------------------------");
		Arrays.stream(matrix).forEach((a)->System.out.println(Arrays.toString(a)));

		int[][] myMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.deepToString(c36.myRotate(myMatrix)));
		
		Arrays.stream(c36.myRotate(myMatrix)).forEach((a)->System.out.println(Arrays.toString(a)));
	}

	// 顺时针旋转 90 度
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// 水平翻转
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-i][j];
				matrix[n-1-i][j] = temp;
			}
		}
		// 主对角线翻转
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	// 顺时针旋转 90 度
	public int[][] myRotate(int[][] matrix) {
		int n = matrix.length;
		int[][] rotateMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotateMatrix[i][j] = matrix[n - 1 - j][i];
			}
		}
		return rotateMatrix;

	}
}
