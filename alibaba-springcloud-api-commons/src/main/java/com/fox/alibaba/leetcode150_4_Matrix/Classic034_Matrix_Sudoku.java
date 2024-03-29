package com.fox.alibaba.leetcode150_4_Matrix;

import java.util.Arrays;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-08 15:47
 * @version 1.0
 */
public class Classic034_Matrix_Sudoku {
	public static void main(String[] args) {
		Classic034_Matrix_Sudoku c034 = new Classic034_Matrix_Sudoku();

		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
						   { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
						   { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
						   { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
						   { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
						   { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
						   { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
						   { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
						   { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(c034.isValidSudoku1(board));
	}
	public boolean isValidSudoku1(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
	}

	public boolean isValidSudoku(char[][] board) {
		
		boolean[] numX = new boolean[9];
		boolean[] numY = new boolean[9];
		boolean[] numArea1 = new boolean[9];
		Arrays.fill(numArea1, false);
		boolean[] numArea2 = new boolean[9];
		Arrays.fill(numArea2, false);
		boolean[] numArea3 = new boolean[9];
		Arrays.fill(numArea3, false);
		boolean[] numArea4 = new boolean[9];
		Arrays.fill(numArea4, false);
		boolean[] numArea5 = new boolean[9];
		Arrays.fill(numArea5, false);
		boolean[] numArea6 = new boolean[9];
		Arrays.fill(numArea6, false);
		boolean[] numArea7 = new boolean[9];
		Arrays.fill(numArea7, false);
		boolean[] numArea8 = new boolean[9];
		Arrays.fill(numArea8, false);
		boolean[] numArea9 = new boolean[9];
		Arrays.fill(numArea9, false);

		
		// row
		for (int j = 0; j < 9; j++) {
			Arrays.fill(numX, false);
			for (int i = 0; i < 9; i++) {
				if(board[i][j] != '.') {
					if(numX[board[i][j]-'0'-1] == false) {
						numX[board[i][j]-'0'-1] = true;
					}else {
						return false;
					}
					
				}
				
			}
		}
		// col
		for (int i = 0; i < 9; i++) {
			Arrays.fill(numY, false);
			for (int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					if(numY[board[i][j]-'0'-1] == false) {
						numY[board[i][j]-'0'-1] = true;
					}else {
						return false;
					}
					
				}
				
			}
		}
		
		// area
		for (int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 9; j++) {
				
				if (i<3 && j<3) {
					if (board[i][j] != '.') {
						if(!numArea1[board[i][j]-'0'-1]) {
							numArea1[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				}
				if (i>=3 && i<6 && j<3) {

					if (board[i][j] != '.') {
						if(!numArea2[board[i][j]-'0'-1]) {
							numArea2[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				if (i>=6 && i<9 && j<3) {

					if (board[i][j] != '.') {
						if(!numArea3[board[i][j]-'0'-1]) {
							numArea3[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				
				if (i<3 && j>=3 && j<6) {

					if (board[i][j] != '.') {
						if(!numArea4[board[i][j]-'0'-1]) {
							numArea4[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				if (i>=3 && i<6 && j>=3 && j<6) {

					if (board[i][j] != '.') {
						if(!numArea5[board[i][j]-'0'-1]) {
							numArea5[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				if (i>=6 && j>=3 && j<6) {

					if (board[i][j] != '.') {
						if(!numArea6[board[i][j]-'0'-1]) {
							numArea6[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				
				if (i<3 && j>=6 && j<9) {

					if (board[i][j] != '.') {
						if(!numArea7[board[i][j]-'0'-1]) {
							numArea7[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				if (i>=3 && i<6 && j>=6 && j<9) {

					if (board[i][j] != '.') {
						if(!numArea8[board[i][j]-'0'-1]) {
							numArea8[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				if (i>=6 && j>=6 && j<9) {

					if (board[i][j] != '.') {
						if(!numArea9[board[i][j]-'0'-1]) {
							numArea9[board[i][j]-'0'-1] = true;
						}else {
							return false;
						}
						
					}
				
				}
				
			}
			
					
			
		}
		
		
		return true;
	}
}
