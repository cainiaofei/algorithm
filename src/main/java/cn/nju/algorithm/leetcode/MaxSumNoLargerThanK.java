package cn.nju.algorithm.leetcode;

/**
 * @date 2017.10.20
 * @description Max Sum of Rectangle No Larger Than K 
 */
public class MaxSumNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	int max = Integer.MIN_VALUE;
    	int[][] matrixSum = getMatrixSum(matrix);
    	/**
    	 * [leftRow][leftCol]->[rightRow][rightCol] = [rightRow][rightCol]-[leftRow-1][rightCol]-
    	 * [rightRow][leftCol-1]+[leftRow-1][leftCol-1] 
    	 */
    	for(int leftRow=0; leftRow<matrix.length;leftRow++) {
    		for(int leftCol=0; leftCol<matrix[leftRow].length;leftCol++) {
    			for(int rightRow=leftRow;rightRow<matrix.length;rightRow++) {
    				for(int rightCol=leftCol;rightCol<matrix[rightRow].length;rightCol++) {
    					int cur = matrixSum[rightRow][rightCol] - (leftRow==0?0:matrixSum[leftRow-1][rightCol])
    							-(leftCol==0?0:matrixSum[rightRow][leftCol-1]) + 
    							(leftRow*leftCol==0?0:matrixSum[leftRow-1][leftCol-1]);
    					if(cur<=k) {
    						max = Math.max(max,cur);
    					}
    				}
    			}
    		}
    	}
    	return max;
    }

    /**
     * @decription dynamic plan to deal with sum from (0,0) to (i,j).
     * dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]
     */
	private int[][] getMatrixSum(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length;i++) {
			for(int j = 0; j < matrix[0].length;j++) {
				dp[i][j] = (i==0?0:dp[i-1][j]) + (j==0?0:dp[i][j-1]) - ((i==0||j==0)?0:dp[i-1][j-1])
						+ matrix[i][j];
			}
		}
		return dp;
	}
	
	public static void main(String[] args) {
		MaxSumNoLargerThanK s = new MaxSumNoLargerThanK();
		int[][] matrix = {
		                {1, 0, 1},
		                {0, -2,3}
		};
		int k = 2;
		System.out.println(s.maxSumSubmatrix(matrix, k));
	}
}