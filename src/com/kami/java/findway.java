package com.kami.java;
import java.util.Scanner;


public class findway {
	static volatile int result = 0;
	static int high = 0;
	static int wight = 0;
	public static void findWay(int[][] a, int i, int j){
		if (i==0&&j==(wight-1)) {
			result++;
		}
		if(a[i][j]==0) return; 
		if (i>0&&j<(wight-1)) {
			findWay(a, i-1, j+1);
		}
		if (i>0) {
			findWay(a, i-1, j);
		}
		if (j<(wight-1)) {
			findWay(a, i, j+1);
		} 
	}
	public static void main(String[] args){
		Scanner inScanner = new Scanner(System.in);
		high = inScanner.nextInt();
		wight = inScanner.nextInt();
		int[][] a = new int[high][wight];
		for (int i = 0; i < high; i++) {
			for (int j = 0; j < wight; j++) {
				a[i][j] = inScanner.nextInt();
			}
		}
		findWay(a, high-1, 0);
		System.out.println(result);
		
	}
}
