package com.kami.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.tools.Tool;

/**
 * Binary Tree Zigzag Level Order Traversal
 * @author shidian
 *
 */
public class Leetcode_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		//this is a iteration method
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Stack<TreeNode> container = new Stack<>();
		boolean isTop = true;
		container.add(root);
		int currentLine = 0;
		int nextLine = 1;
		while(!container.isEmpty()) {
			currentLine = nextLine;
			nextLine = 0;
			TreeNode temp;
			List<Integer> currentLineList = new ArrayList<>();
			if (isTop) {
				while(currentLine>0){
					temp = container.remove(0);
					
					if (temp.left != null) {
						container.add(temp.left);
						nextLine++;
					}
					if (temp.right!=null) {
						container.add(temp.right);
						nextLine++;
					}
					currentLineList.add(temp.val);
					currentLine--;
				}
			}
			else{
				while(currentLine>0){
					temp = container.remove(container.size()-1);
					if (temp.right!=null) {
						container.add(0,temp.right);
						nextLine++;
					}
					if (temp.left != null) {
						container.add(0,temp.left);
						nextLine++;
					}
					
					currentLineList.add(temp.val);
					currentLine--;
				}
			}
			result.add(currentLineList);
			isTop = isTop==true?false:true;
		}
		return result;
	}
	
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		//this is a recursion method
		List<List<Integer>> result = new ArrayList<>();
		DFS_Travel(root, 0, result, true);
		return result;
	}
	
	private void DFS_Travel(TreeNode root, int depth, List<List<Integer>> result, boolean isLeft){
		if (root == null) {
			return;
		}
		if (depth > result.size()) {
			result.add(new LinkedList<>());
		}
		List<Integer> temp = result.get(depth);
		if (isLeft) {
			temp.add(root.val);
		}
		else temp.add(0,root.val);
		
		
		DFS_Travel(root.left, depth+1, result, !isLeft);
		DFS_Travel(root.right, depth+1, result, !isLeft);
	}
	
	public static void main(String[] args){
		Stack<Integer> temp= new Stack<>();
		temp.add(1);
		temp.add(2);
		temp.push(3);
		temp.push(4);
		temp.pop();
		Deque<Integer> curent = new ArrayDeque<>();
		System.out.println(temp);
	}
}
