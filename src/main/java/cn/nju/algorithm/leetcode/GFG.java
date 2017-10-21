package cn.nju.algorithm.leetcode;

import java.util.Scanner;
/**
 * @author zzf
 * @date 2017.10.21
 * @description the method to process subMatrix sum. 
 */
class GFG {
	
	public void process() {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		while(testCase!=0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int[][] matrix = new int[rows][cols];
			for(int i = 0; i < rows;i++) {
				for(int j = 0; j < cols;j++) {
					matrix[i][j] = scan.nextInt();
				}
			}
			testCase--;
			int res = getSubMatrixSum(matrix);
			System.out.println(res);
		}
		scan.close();
	}
	
	private int getSubMatrixSum(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		for(int leftCol=0;leftCol<matrix[0].length;leftCol++) {
			int[] arrSum = new int[matrix.length];
			for(int rightCol=leftCol; rightCol<matrix[0].length;rightCol++) {
				for(int row=0; row < matrix.length;row++) {
					arrSum[row] += matrix[row][rightCol];
				}
				int curMax = getCurMax(arrSum);
				max = Math.max(max, curMax);
			}
		}
		return max;
	}

	private int getCurMax(int[] nums) {
		int max = nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1; i < nums.length;i++) {
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			max = Math.max(max,dp[i]);
		}
		return max;
	}

	public static void main (String[] args) {
		GFG gfg = new GFG();
		gfg.process();
	}
}