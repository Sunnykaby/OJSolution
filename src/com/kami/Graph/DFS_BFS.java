package com.kami.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFS {
	// 邻接矩阵存储图
	// --A B C D E F G H I
	// A 0 1 0 0 0 1 1 0 0
	// B 1 0 1 0 0 0 1 0 1
	// C 0 1 0 1 0 0 0 0 1
	// D 0 0 1 0 1 0 1 1 1
	// E 0 0 0 1 0 1 0 1 0
	// F 1 0 0 0 1 0 1 0 0
	// G 0 1 0 1 0 1 0 1 0
	// H 0 0 0 1 1 0 1 0 0
	// I 0 1 1 1 0 0 0 0 0

	// 顶点数
	private int number = 9;
	// 记录顶点是否被访问
	private boolean[] flag;
	// 顶点
	private String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
	// 边
	private int[][] edges = { { 0, 1, 0, 0, 0, 1, 1, 0, 0 },
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 0, 0, 1, 0, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 0, 0, 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0, 0, 0, 0, 0 } };

	public void DFSTraverse() {
		flag = new boolean[number];// 每次调用是新的访问
		for (int i = 0; i < number; i++) {
			if (!flag[i]) {
				DFSRecursion(i);
			}
		}
	}

	// DFS递归
	public void DFSRecursion(int i) {
		flag[i] = true;
		System.out.print(vertexs[i] + " ");
		for (int j = 0; j < number; j++) {
			if (!flag[j] && edges[i][j] == 1) {

				DFSRecursion(j);

			}
		}
	}

	public void DFSUnRecursion() {
		flag  = new boolean[number];
		Stack<Integer> dfsStack = new Stack<Integer>();
		for (int i = 0; i < number; i++) {
			if (!flag[i]) {
				dfsStack.push(i);
				flag[i] = true;
				System.out.print(vertexs[i] + " " );
				break;
			}
		}
		while (!dfsStack.isEmpty()) {
			int index = dfsStack.peek();
			boolean isAllTraversed = true;
			for (int i = 0; i < number; i++) {
				if (!flag[i]&&edges[index][i]==1) {
					dfsStack.push(i);
					flag[i] = true;
					System.out.print(vertexs[i] + " ");
					isAllTraversed = false;
					break;
				}
			}
			if (isAllTraversed) {
				dfsStack.pop();
			}
		}
	}
	//因为是广度搜索，所以不存在递归的情景 
	public void BFSTraverseUnRecursion(){
		flag = new boolean[number];
		Queue<Integer> bFSQueue = new LinkedList<Integer>();
		for (int i = 0; i < number; i++) {
			if (!flag[i]) {
				bFSQueue.offer(i);
				flag[i] = true;
				break;
			}
			
		}
		while(!bFSQueue.isEmpty()){
			int index = bFSQueue.poll();
			for (int i = 0; i < number; i++) {
				if (!flag[i]&&edges[index][i]==1) {
					bFSQueue.offer(i);
					flag[i] = true;
				}
			}
			System.out.print(vertexs[index] + " ");
			}
	}

	public static void main(String[] args) {
		DFS_BFS graDfs = new DFS_BFS();
		graDfs.DFSTraverse();
		System.out.println();
		graDfs.DFSUnRecursion();
		System.out.println();
		graDfs.BFSTraverseUnRecursion();

	}
}
