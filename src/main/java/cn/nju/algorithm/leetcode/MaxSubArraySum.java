package cn.nju.algorithm.leetcode;

class MaxSubArraySum {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	int maxSum = Integer.MIN_VALUE;
		for(int leftRow=0; leftRow<matrix.length; leftRow++) {
			for(int leftCol=0; leftCol<matrix[leftRow].length;leftCol++) {
				for(int rightRow=leftRow; rightRow<matrix.length;rightRow++) {
					for(int rightCol=leftCol;rightCol<matrix[rightRow].length;rightCol++) {
						int record = maxSum;
						maxSum = Math.max(maxSum, getSubSum(matrix,leftRow,leftCol,rightRow,rightCol));
						if(maxSum>k) {
							maxSum = record;
						}
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
    	MaxSubArraySum s = new MaxSubArraySum();
    	int[][] matrix = {{2,2,-1}};
    	int k = 0;
    	System.out.println(s.maxSumSubmatrix(matrix, k));
    }
}