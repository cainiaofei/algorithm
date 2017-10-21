package cn.nju.algorithm.geekforgeek;

import java.util.Scanner;

public class MaxSubMatrixSum {
	
	public void process() {
		Scanner scan = new Scanner(System.in);
		int testCaseNum = scan.nextInt();
		while(testCaseNum!=0) {
			int[][] matrix = new int[scan.nextInt()][scan.nextInt()];
			for(int i = 0; i < matrix.length;i++) {
				for(int j = 0; j < matrix[i].length;j++) {
					matrix[i][j] = scan.nextInt();
				}
			}
			testCaseNum--;
			System.out.println(getMaxSubMatrixSum(matrix));
		}
		scan.close();
	}
	
	public int getMaxSubMatrixSum(int[][] matrix) {
		int maxSum = Integer.MIN_VALUE;
		for(int leftRow=0; leftRow<matrix.length; leftRow++) {
			for(int leftCol=0; leftCol<matrix[leftRow].length;leftCol++) {
				for(int rightRow=leftRow; rightRow<matrix.length;rightRow++) {
					for(int rightCol=leftCol;rightCol<matrix[rightRow].length;rightCol++) {
						maxSum = Math.max(maxSum, getSubSum(matrix,leftRow,leftCol,rightRow,rightCol));
					}
				}
			}
		}
		return maxSum;
	}

	private int getSubSum(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol) {
		int sum = 0;
		for(int row=leftRow;row<=rightRow;row++) {
			for(int col=leftCol;col<=rightCol;col++) {
				sum += matrix[row][col];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		MaxSubMatrixSum maxSubMatrix = new MaxSubMatrixSum();
		maxSubMatrix.process();
	}
}
