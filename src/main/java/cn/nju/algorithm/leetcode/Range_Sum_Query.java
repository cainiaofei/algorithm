package cn.nju.algorithm.leetcode;
/**
 * Range Sum Query - Mutable 
 */
class Range_Sum_Query {
	private int[] nums;
	private int[] treeArr;
    public Range_Sum_Query(int[] nums) {
        this.nums = nums;
        if(nums!=null) {
        	 treeArr = new int[nums.length];
             buildtreeArr();
        }
    }
    
    private void buildtreeArr() {
		if(nums.length==0) {
			return ;
		}
		else {
			treeArr[0] = nums[0];
			for(int i = 1; i < nums.length;i++) {
				int count = minBit(i);
				while(count != 0) {
					treeArr[i] += nums[i-count+1];
					count--;
				}
			}
		}
	}

	public void update(int i, int val) {
        int incre = val - nums[i];
        nums[i] = val;
        
        int next = i;
        while(next<nums.length) {
        	treeArr[next] += incre;
        	next += minBit(next);
        	if(next==0) {
        		break;
        	}
        }
    }
    
    public int sumRange(int i, int j) {
        int right = sum(j);
        int left = sum(i);
        return right - left + nums[i];
    }
    
    private int sum(int pos) {
		if(pos==0) {
			return nums[0];
		}
		else {
			int res = treeArr[pos];
			int next = pos - minBit(pos);
			return res + sum(next);
		}		
	}

	private int minBit(int x) {
    	return x & (-x);
    }
	
	public static void main(String[] args) {
		int[] nums = {-1};
		Range_Sum_Query tool = new Range_Sum_Query(nums);
		System.out.println(tool.sumRange(0, 0));
		tool.update(0,1);
		System.out.println(tool.sumRange(0, 0));
	}
	
	/**
	 * ["Range_Sum_Query","sumRange","update","sumRange"]
	 * [[[-1]],[0,0],[0,1],[0,0]]
	 */
}

