package com.kami.leetcode;

public class Leetcode_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        // if(p==null) return q;
        // if(q==null) return p;
        TreeNode result = null;
        if(q==null&&p==null){
            return null;
        }
        else if(q==null){
            if(findNode(root, p)) return p;
        }
        else if(p==null){
            if(findNode(root, q)) return q;
        }
        else {
            TreeNode l = p.val < q.val?p:q;
            TreeNode r = p.val < q.val?q:p;
            while(root!=null){
                if(r.val < root.val) root = root.left;
                else if(l.val > root.val) root = root.right;
                else if(l.val < root.val && r.val > root.val) {
                    if(findNode(root, l)&&findNode(root, r)) return root;
                    else break;
                }
                else if(r.val ==root.val) {
                    if(findNode(root, l)) return root;
                    else break;
                }
                else if(l.val == root.val){
                    if(findNode(root, r)) return root;
                    else break;
                }
            }
        }
        return result;
        
    }
    
    public boolean findNode(TreeNode root, TreeNode target){
        if(root == null) return false;
        if(root.val == target.val) return true;
        else if(target.val < root.val) return findNode(root.left, target);
        else return findNode(root.right, target);
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(10);
    	TreeNode l1 = new TreeNode(5);
    	TreeNode r1 = new TreeNode(15);
    	root.left = l1;
    	root.right = r1;
    	TreeNode r2 = new TreeNode(21);
    	r1.right = r2;
    	Leetcode_235 leetcode_235 = new Leetcode_235();
    	TreeNode temp = leetcode_235.lowestCommonAncestor(root, l1, r2);
    	System.out.println(temp.val);
    }
}
