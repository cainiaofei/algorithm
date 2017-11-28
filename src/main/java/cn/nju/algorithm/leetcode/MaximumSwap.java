package cn.nju.algorithm.leetcode;

/**
 * @author zzf
 * @date 2017.11.28
 * @description algorithm: find the max value from right to left, example: 1244988891, the second 9 from right is 
 * 	what we learn and then after swap the digit change to 9244988811.
 * 
 * @bug Input: 98368
 *      Output: 98368
 *      Expected: 98863
 * @fix_strategy swap mean there should be two numbers, first: find the first position of the former. The former
 * interval if exist should meet this rule: the first value which violate desending order. then we can be sure the 
 * former should in [0,..]. Then we get max value int right interval [..+1,len-1], then find the former actual position
 * through max value in right.
 */
class MaximumSwap {
    public int maximumSwap(int num) {
        char[] chs = (num+"").toCharArray();
        int[] arr = transferToInt(chs);
        //find left interval
        int leftBorder = getLeftBorder(arr);
        if(leftBorder==arr.length-1) {
        	return num;
        }
        else {
        	int rightPos = getMaxRightValue(arr,leftBorder+1);
        	int leftPos = findActualPosInLeft(arr,leftBorder,rightPos);
        	swap(arr,leftPos,rightPos);
            StringBuilder sb = new StringBuilder();
            for(int ele:arr) {
            	sb.append(ele);
            }
            return Integer.valueOf(sb.toString());
        }
    }
    
    private int findActualPosInLeft(int[] arr, int leftBorder, int rightPos) {
		return findFirstLessThanTarget(arr,0,leftBorder,arr[rightPos]);
	}
    
    private int findFirstLessThanTarget(int[] arr,int left,int right,int target) {
    	if(left>right) {
    		return left;
    	}
    	else {
    		int mid = (left + right) / 2;
    		if(target>arr[mid]) {
    			return findFirstLessThanTarget(arr,left,mid-1,target);
    		}
    		else {
    			return findFirstLessThanTarget(arr,mid+1,right,target);
    		}
    	}
    }

	private int getMaxRightValue(int[] arr, int start) {
		int max = arr[start];
		int pos = start;
		for(int i = start+1; i < arr.length;i++) {
			if(max<=arr[i]) {
				pos = i;
				max = arr[i];
			}
		}
		return pos;
	}

	/**
     * descend orfer 
     */
    private int getLeftBorder(int[] arr) {
		for(int i = 0; i < arr.length-1;i++) {
			if(arr[i]<arr[i+1]) {
				return i;
			}
		}
		return arr.length-1;
	}

	private void swap(int[] arr, int former, int latter) {
    	int temp = arr[former];
    	arr[former] = arr[latter];
    	arr[latter] = temp;
	}

	private int[] transferToInt(char[] chs) {
		int[] arr = new int[chs.length];
		for(int i = 0; i < chs.length;i++) {
			arr[i] = (int)(chs[i]-'0');
		}
		return arr;
	}

	public static void main(String[] args) {
		MaximumSwap s = new MaximumSwap();
    	int num = 98368;
    	System.out.println(s.maximumSwap(num));
    }
}