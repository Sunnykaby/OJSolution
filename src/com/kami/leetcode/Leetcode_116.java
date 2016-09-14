package com.kami.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Leetcode_116 {
	public void connect(TreeLinkNode root) {
		//here we use the queue and BFS to do this job
		int curLine = 0, nextLine = 0;
		Queue<TreeLinkNode> nodeQueue = new LinkedList<>();
		if (root == null) {
			return;
		}
		nodeQueue.add(root);
		curLine = 1;
		while(!nodeQueue.isEmpty()){
			while(curLine > 0){
				TreeLinkNode cur = nodeQueue.poll();
				if (cur == null) {
					return;
				}
				if (cur.left != null)  {nodeQueue.add(cur.left);nextLine++;}
				if (cur.right != null) {nodeQueue.add(cur.right);nextLine++;}
				if (curLine == 1) {
					cur.next = null;
				}
				else cur.next = nodeQueue.peek();
				curLine--;
			}
			if (nextLine != 0) {
				curLine = nextLine;
				nextLine = 0;
			}
		}
	}
}
 