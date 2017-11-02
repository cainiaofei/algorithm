package cn.nju.algorithm.hiho;

import java.util.Scanner;

public class Main {
	
	public void process() {
		Scanner scan = new Scanner(System.in);
		int times = scan.nextInt();
		int target = scan.nextInt();
		scan.close();
		double possibility = caculatePossibility(times,target);
		String res = possibility + "";
		res += "00";
		//System.out.println(possibility);
		System.out.println(res.substring(0, res.indexOf(".")+3));
	}
	
	private double caculatePossibility(int times, int target) {
		int[][] dp = new int[times+1][target+1];
		dp[0][0] = 1;
		for(int i = 1;i<=times;i++) {//
			for(int j = 1; j<= target;j++) {
				for(int k = 1; k<=6;k++) {
					dp[i][j] += (j-k)<0?0:dp[i-1][j-k];
				}
			}
		}
		double possibility = dp[times][target] / Math.pow(6, times);
		double percent = possibility * 100;
		String percentStr = String.format("%.2f", percent);
		return Double.valueOf(percentStr);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.process();
	}
}
