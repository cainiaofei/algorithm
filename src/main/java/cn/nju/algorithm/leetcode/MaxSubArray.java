package cn.nju.algorithm.leetcode;
/**
 * @author zzf 
 * @date 2017/10/21
 * @description the algorithm  used is very complicate, this time is beautiful. 
 */
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        for(int i = 1; i < nums.length;i++) {
        	dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	MaxSubArray s = new MaxSubArray();
    	System.out.println(s.maxSubArray(nums));
    }
}