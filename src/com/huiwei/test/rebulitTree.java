package com.huiwei.test;

import java.util.Scanner;

public class rebulitTree {
	public static void postOrder(String pre, String in, int length) throws Exception{
		if (length == 0) {
			return;
		}
		char root = pre.charAt(0);
		int index = -1;
		for (int i = 0; i < length; i++) {
			if (in.charAt(i) == root) {
				index = i;
				break;
			}
		}
		if (index==-1) {
			throw new Exception();
		}
		postOrder(pre.substring(1,index+1), in.substring(0,index), index);
		postOrder(pre.substring(index+1), in.substring(index+1), length-index-1);
		System.out.print(root+" ");
		
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int number = in.nextInt();
			int[] preOrder = new int[number];
			int[] inOrder = new int[number];
			StringBuilder preString  = new StringBuilder();
			StringBuilder inString = new StringBuilder();
			int tempNum = number;
			for (int i = 0; i < tempNum; i++) {
				preString.append(in.nextInt());
			}
			tempNum = number;
			for (int i = 0; i < tempNum; i++) {
				inString.append(in.nextInt());
			}
			
			try {
				postOrder(preString.toString(), inString.toString(), number);
				System.out.println();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("No");
			}
			
			
		}
	}
}
