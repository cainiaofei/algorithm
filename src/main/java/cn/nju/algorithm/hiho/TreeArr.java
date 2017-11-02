package cn.nju.algorithm.hiho;

public class TreeArr {
	public int minBit(int x) {
		return x & (-x);
	}
	
	public void buildTreeArr(int[][] matrix) {
		if(matrix==null||matrix.length==0) {
			return ;
		}
		else {
			int[][] treeArr = new int[matrix.length][matrix[0].length];
			
		}
	}
	
	private int[] getColSum(int[][] matrix) {
		// TODO Auto-generated method stub
		return null;
	}

	private int[] getRowSum(int[] is) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		TreeArr m = new TreeArr();
	}
}
