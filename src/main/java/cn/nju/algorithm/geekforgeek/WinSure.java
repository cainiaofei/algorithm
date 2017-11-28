package cn.nju.algorithm.geekforgeek;

import java.util.Scanner;

public class WinSure {
	
	public void process() {
		Scanner scan = new Scanner(System.in);
		int ceil = scan.nextInt();
		int target = scan.nextInt();
		scan.close();
		//we enemy cur target
		int[][][][] record = new int[target][target][ceil][target];
		helper(record,0,0,ceil,target);
	}
	
	private void helper(int[][][][] record,int we,int enemy,int ceil,int target) {
		dfs(record,we,enemy,ceil,target);
		
		for(int i = 1; i<=Math.min(ceil,target);i++) {
			
		}
	}

	private boolean dfs(int[][][][] record, int we, int enemy, int ceil, int target) {
		if(we==target) {
			return true;
		}
		else if(enemy==target||we>target) {
			return false;
		}
		else {
			for(int i = 1; i <= Math.min(ceil, target-we);i++) {
				
			}
			return true;
		}
		
	}

	public static void main(String[] args) {
		WinSure winSure = new WinSure();
	}
}








