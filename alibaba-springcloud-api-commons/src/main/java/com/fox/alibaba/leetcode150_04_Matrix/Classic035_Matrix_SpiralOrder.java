package com.fox.alibaba.leetcode150_04_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-11 17:15
 * @version 1.0
 */
public class Classic035_Matrix_SpiralOrder {
	public static void main(String[] args) {
		Classic035_Matrix_SpiralOrder c35 = new Classic035_Matrix_SpiralOrder();
		int[][] matrix = { { 1 } };

		System.out.println(c35.spiralOrder(matrix));
		
		
		
	}
	// 削头, 然后逆时针旋转90 
	public List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		while (matrix.length >= 1) {
			for (int num : matrix[0]) {
				res.add(num);
			}
			matrix = reversalArr(matrix);
		}
		return res;
	}

	private int[][] reversalArr(int[][] matrix) {
		int m = matrix[0].length;
		int n = matrix.length - 1;
		int[][] reArr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				reArr[i][j] = matrix[j + 1][m - i - 1];
			}
		}
		return reArr;
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];

		List<Integer> ans = new ArrayList<>();
		int i = 0, j = 0;
		boolean uFlag = false, dFlag = false, lFlag = false, rFlag = false;
		while (true) {

			ans.add(matrix[i][j]);
			visited[i][j] = true;

			if (i - 1 >= 0 && !visited[i - 1][j]) {
				uFlag = true;
			} else {
				uFlag = false;
			}
			if (i + 1 < m && !visited[i + 1][j]) {
				dFlag = true;
			} else {
				dFlag = false;
			}
			if (j - 1 >= 0 && !visited[i][j - 1]) {
				lFlag = true;
			} else {
				lFlag = false;
			}
			if (j + 1 < n && !visited[i][j + 1]) {
				rFlag = true;
			} else {
				rFlag = false;
			}

			if (!uFlag && !dFlag && !lFlag && !rFlag) {
				break;
			}
			if ((!uFlag && !dFlag && !lFlag && rFlag) || (!uFlag && dFlag && !lFlag && rFlag)) {
				j++;
			}
			if ((!uFlag && dFlag && !lFlag && !rFlag) || (!uFlag && dFlag && lFlag && !rFlag)) {
				i++;
			}
			if ((!uFlag && !dFlag && lFlag && !rFlag) || (uFlag && !dFlag && lFlag && !rFlag)) {
				j--;
			}

			if ((uFlag && !dFlag && !lFlag && !rFlag) || (uFlag && !dFlag && !lFlag && rFlag)) {
				i--;
			}

		}

		return ans;

	}
}
