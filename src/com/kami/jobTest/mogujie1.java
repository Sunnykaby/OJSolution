package com.kami.jobTest;

import java.util.Scanner;

public class mogujie1 {
	public static  void main(String[] args){
		//首先输入数据
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int[] numbers = new int[number];
		for (int i = 0; i < number; i++) {
			numbers[i] = in.nextInt();
		}
		if (number == 1) {
			System.out.println(0);
			return;
		}
		int[] diff = new int[number];//diff[i] = ai - a(i-1)
		for (int i = 1; i < number; i++) {
			diff[i] = numbers[i] - numbers[i-1];
		}
		int tag = 1;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < (number-1); i++) {
			if((numbers[i+1]-numbers[i-1]) < min){
				tag = i;
				min = numbers[i+1]-numbers[i-1];
			}
		}
		
		int max = 0;
		numbers[tag] = 0;
		for (int i = 1; i < number; i++) {
			if (numbers[i]==0) {
				if ((numbers[i+1]-numbers[i-1]) > max) {
					max = numbers[i+1]-numbers[i-1];
					i++;
				}
			}
			else {
				if (diff[i] >max) {
					max = diff[i];
					
				}
			}
		}
		System.out.println(max);
	}
}
