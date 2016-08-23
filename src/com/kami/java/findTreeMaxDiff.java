package com.kami.java;
import java.util.Map;

import com.kami.tree.TreeNode;


public class findTreeMaxDiff {
	private static int max = 0;
	private static int min = 0;
	public int maxDiff(TreeNode root){
		findMax_Min(root);
		return max - min;
	}
	
	public void findMax_Min(TreeNode root){
		if (root == null) {
			return;
		}
		if (root.value > max) {
			max = root.value;
		}
		else if (root.value < min) {
			min = root.value;
		}
		findMax_Min(root.leftTreeNode);
		findMax_Min(root.rightTreeNode);
	}
}
