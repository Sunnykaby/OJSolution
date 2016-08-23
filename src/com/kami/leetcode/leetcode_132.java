package com.kami.leetcode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class leetcode_132 {
    public boolean isBalanced(TreeNode root) {
       try {
		int hight = countHight(root);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
       return true;
    }
    
    public int countHight(TreeNode root) throws Exception{
    	int leftH = 0;
    	int rightH = 0;
    	if (root.left != null) {
			leftH = countHight(root.left);
		}
    	if(root.right != null) rightH = countHight(root.right);
    	if (Math.abs(leftH- rightH) > 1) {
			throw new Exception();
		}
    	return leftH<rightH?rightH:leftH;
    }
}