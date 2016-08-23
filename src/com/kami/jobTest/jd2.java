package com.kami.jobTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class jd2 {
	public static ArrayList<Integer> mark = new ArrayList<Integer>();
	
	public static void maxgift(int[][] a, int source, int i, int j){
		if (i == 5 && j ==5) {
			mark.add(source+a[i][j]);
			return;
		}
		else {
			if(i<5){
				maxgift(a, source+a[i][j], i+1, j);
			}
			if (j<5) {
				maxgift(a, source+a[i][j], i, j+1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] gift = new int[6][6];
		
		while(in.hasNext()){
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					gift[i][j] = in.nextInt();
				}
			}
			mark.clear();
			maxgift(gift, 0, 0, 0);
			Collections.sort(mark,Collections.reverseOrder());
			System.out.println(mark.get(0));
		}
	}

}
