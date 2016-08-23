package com.kami.tree;

public class TreeNode {
	public int value;
	public TreeNode leftTreeNode;
	public TreeNode rightTreeNode;
	private int height;
	TreeNode(){
		height = -1;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
	public String toString(){
		return "The value is " +value+ ", the height is " + height;
	}
}








