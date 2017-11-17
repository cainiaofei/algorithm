package cn.nju.algorithm.hiho;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zzf 
 * @date 2017.10.07
 * @description Robots Crossing River, the bottleneck of this problem is from B to C.
 */
public class MinTime {
	
	public void process() {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		scan.close();
		int timeCost = calculateMinTime(x,y,z);
		System.out.println(timeCost);
	}
	
	private int calculateMinTime(int x, int y, int z) {
		int[] nums = {x,y,z};
		Arrays.sort(nums);
		int times = 0;
		if(nums[2]<=(nums[1]+nums[0])) {
			times = (int)Math.ceil((x+y+z)*1.0/20);
		}
		else {//greedy
			int one = nums[2];
			int other = nums[1]+nums[0];
			while(other>=10) {
				one -= 10;
				other -= 10;
				times++;
			}
			if(other<8) {
				one -= (15-other);
			}
			else {
				one -= other;
			}
			times++;
			times += (int)Math.ceil(one*1.0/15);
		}
		return times * 6;
	}

	public static void main(String[] args) {
		MinTime m = new MinTime();
		m.process();
	}
}
