package cn.nju.algorithm.leetcode;
 

/**
 * @author zzf
 * @date 2017.11.28
 * @problem Trim a Binary Search Tree
 * @description this question is to how to delete node in BST, It will be easy if the deleted node is leaf
 * 	 or it just has one child. Else, its right node replace its position and the left child of its right child will
 *  append the right of its left child, the its left become child of its right.
 *  Example                  6                            6
 *                          / \                          / \
 *                          4 17       delete 17        4  22
 *                            / \      =========>          / \
 *                           10 22                        10 40
 *                            \ / \                        \
 *                           18 20 40                      18
 *                                                          \
 * @bug Runtime Error Message: Line 36: java.lang.NullPointerException
 *       Last executed input: [1,0,2] 1 2    
 * @bug [3,1,4,null,2] 1 2
 *	     Output: [4,1,null,null,2]
 *	     Expected: [1,null,2]                                                  
 */ 
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode trimBST(TreeNode root, int left, int right) {
    	TreeNode header = new TreeNode(1);
    	header.left = root;
    	dfs(header,left,right);
    	return header.left;
    }
    
    private void dfs(TreeNode tn,int left,int right) {
    	if(tn==null) {
    		return ;
    	}
    	//adjust left and right
    	if(tn.left!=null) {
    		int leftValue = tn.left.val;
    		if(!(leftValue>=left && leftValue<=right)) {
    			tn.left = adjustBST(tn.left);
    			dfs(tn,left,right);
    		}
    		else {
    			dfs(tn.left,left,right);
    		}
    	}
    	
    	if(tn.right!=null) {
    		int rightValue = tn.right.val;
    		if(!(rightValue>=left && rightValue<=right)) {
    			tn.right = adjustBST(tn.right);
    			dfs(tn,left,right);
    		}
    		else {
    			dfs(tn.right,left,right);
    		}
    	}
    }
    
    private TreeNode adjustBST(TreeNode tn) {
    	if(tn.left==null && tn.right==null) {
    		tn = null;
    	}
    	else if(tn.left==null||tn.right==null) {
    		tn = (tn.left==null)?tn.right:tn.left;
    	}
    	else {
    		TreeNode rightLeafInLeftChild = getRightLeafInLeftChild(tn.left);
    		rightLeafInLeftChild.right = tn.right.left;
    		tn.right.left = tn.left;
    		tn = tn.right;
    	}
    	
    	return tn;
    }
    
    private void adjustBST(TreeNode parent, TreeNode tn) {
    	if(tn.left==null && tn.right==null) {
    		tn = null;
    	}
    	else if(tn.left==null||tn.right==null) {
    		tn = (tn.left==null)?tn.right:tn.right;
    	}
    	else {
    		TreeNode rightLeafInLeftChild = getRightLeafInLeftChild(tn.left);
    		rightLeafInLeftChild.right = tn.right.left;
    		tn.right.left = tn.left;
    		tn = tn.right;
    	}
    	
    	if(parent.val>tn.val) {
    		parent.left = tn;
    	}
    	else {
    		parent.right = tn;
    	}
    }
    
    private TreeNode getRightLeafInLeftChild(TreeNode root) {
		while(root.right!=null) {
			root = root.right;
		}
		return root;
	}

	public static void main(String[] args) {
    	Solution s = new Solution();
    	TreeNode tn = new TreeNode(3);
    	tn.left = new TreeNode(1);
    	tn.right = new TreeNode(4);
    	tn.left.right = new TreeNode(2);
    	s.trimBST(tn, 1, 2);
    }
}