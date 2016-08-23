package com.kami.leetcode;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.huiwei.test.commandMatch;

public class LCS {
	private int[][] common;
	private int[][] path;
	public void searchString(String a, String b){
		int lengtha = a.length();
		int lengthb = b.length();
		char[] arrayA = a.toCharArray();
		char[] arrayB = b.toCharArray();
		common = new int[lengtha+1][lengthb+1];
		path = new int[lengtha+1][lengthb+1];
		
		for (int i = 1; i <= arrayA.length; i++) {
			for (int j = 1; j <= arrayB.length; j++) {
				if (arrayA[i-1] == arrayB[j-1]) {
					common[i][j] = common[i-1][j-1]+1;
					path[i][j] = 0;
				}
				else if (common[i][j-1] >= common[i-1][j]) {
					common[i][j] = common[i][j-1];
					path[i][j] = -1;
				}
				else if (common[i][j-1] < common[i-1][j]) {
					common[i][j] = common[i-1][j];
					path[i][j] = 1;
				}
			}
		}
		for (int i = 1; i <= arrayA.length; i++) {
			for (int j = 1; j <= arrayB.length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int findLCS(String a, String b){
		searchString(a, b);
		return common[a.length()][b.length()];
	}
	
	public void printLCS(String a, String b){
		int number = findLCS(a, b);
		StringBuilder lcsBuilder = new StringBuilder();
		int line  =a.length();
		int cow = b.length();
		while(number>0){
			if (path[line][cow]==0) {
				lcsBuilder.insert(0, a.charAt(line-1));
				line--;
				cow--;
				number--;
			}
			else if (path[line][cow] == 1) {
				line--;
			}
			else if (path[line][cow]==-1) {
				cow--;
			}
		}
		System.out.println(lcsBuilder.toString());
	}
	
	public static void main(String[] args){
		String aString= "BBDGERTAA";
		String bString = "BDERTE";
		LCS lcs = new LCS();
		lcs.printLCS(aString,bString);
	}
}
