package cn.nju.algorithm.geekforgeek;

/**
 * 304. Range Sum Query 2D - Immutable 
 */

class Range_Sum_Query_2D {
	int[][] matrix;
	int[][] matrixSum;
	/**
	 * sum[i][j] = [i-1][j] + [i][j-1] - nums[i-1][j-1] 
	 */
    public Range_Sum_Query_2D(int[][] matrix) {
    	this.matrix = matrix;
    	
    	if(matrix==null||matrix.length==0) {
    		return ;
    	}
        matrixSum = new int[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length;row++) {
        	for(int col = 0; col < matrix[row].length;col++) {
        		matrixSum[row][col] = (row==0?0:matrixSum[row-1][col]) + (col==0?0:matrixSum[row][col-1])
        				-(row*col==0?0:matrixSum[row-1][col-1]) + matrix[row][col];
        	}
        }
    }
    
    /**
     * (i1,j1)->(i2,j2) = [i2][j2] - [i1-1][j2]-[i2][j1-1]+[i1-1][j1-1] 
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(matrix==null||matrix.length==0) {
    		return 0;
    	}
        return matrixSum[row2][col2] - (row1==0?0:matrixSum[row1-1][col2]) - 
        		(col1==0?0:matrixSum[row2][col1-1]) + (row1*col1==0?0:matrixSum[row1-1][col1-1]); 
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {
    	          {3, 0, 1, 4, 2},
    	          {5, 6, 3, 2, 1},
    	          {1, 2, 0, 1, 5},
    	          {4, 1, 0, 1, 7},
    	          {1, 0, 3, 0, 5}
    	          };
    	Range_Sum_Query_2D main = new Range_Sum_Query_2D(matrix);
    	int res = main.sumRegion(2,1,4,3);
    	System.out.println(res);
    }
}


/**
 * Your Range_Sum_Query_2D object will be instantiated and called as such:
 * Range_Sum_Query_2D obj = new Range_Sum_Query_2D(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */