package com.kami.jobTest;

import java.util.Scanner;


public class mogujie2 {
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		int p = in.nextInt();
		int n = in.nextInt();
		int[] bukket = new int[p];
		for (int i = 0; i < bukket.length; i++) {
			bukket[i] = 0;
		}
		int number = 0;
		int index = 1;
		while(n>0){
			number = in.nextInt();
			if (bukket[number%p]==1) {
				System.out.println(index);
				return ;
			}
			else {
				bukket[number%p] = 1;
			}
			index++;
			n--;
		}
		System.out.println(-1);
	}
}
