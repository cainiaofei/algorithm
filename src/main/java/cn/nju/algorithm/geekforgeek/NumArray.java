package cn.nju.algorithm.geekforgeek;
/**
 * Range Sum Query - Immutable 
 */
class NumArray {
	private int[] nums;
	private int[] treeArr;;
	
    public NumArray(int[] nums) {
        this.nums = nums;
        this.treeArr = new int[nums.length];
        init();
    }
    
    public void init() {
    	if(nums.length==0) {
    		return ;
    	}
    	treeArr[0] = nums[0];
    	for(int i = 1;i<nums.length;i++) {
    		int count = lowbit(i);
    		while(count!=0) {
    			treeArr[i] += nums[i-count+1];
    			count--;
    		}
    	}
    }
    
    public int lowbit(int x) {
    	return x & (-x);
    }
    
    public int sumRange(int i, int j) {
        int right = sum(j);
        int left = sum(i);
        return right - left + nums[i];
    }
    
    private int sum(int pos) {
    	if(pos==0) {
    		return treeArr[0];
    	}
    	else {
    		int res = treeArr[pos];
    		int next = pos - lowbit(pos);
    		return res + sum(next);
    	}
	}

	public static void main(String[] args) {
    	int[] nums = {};
    	NumArray obj = new NumArray(nums);
    	System.out.println(obj.sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */