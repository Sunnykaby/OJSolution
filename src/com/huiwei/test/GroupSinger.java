package com.huiwei.test;

import java.util.ArrayList;
import java.util.Scanner;

public class GroupSinger {
	
	public static void main(String[] args){
		
		Scanner inScanner = new Scanner(System.in);
		int number = inScanner.nextInt();
		ArrayList<Integer> singer = new ArrayList<Integer>(number);
		while(number > 0){
			singer.add(inScanner.nextInt());
			number--;
		}
		number = singer.size();
		int[] leftUP = new int[number];
		int[] rightUp = new int[number];
		leftUP[0] = 1;
		rightUp[number-1] = 1;
		//正序
		for (int i = 0; i < number; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (singer.get(i) > singer.get(j) && leftUP[j]+1 > max) {
					max = leftUP[j] + 1;
					
				}
			}
			leftUP[i] = max;
		}
		//逆序
		for (int i = number-1; i >= 0; i--) {
			int max = 1;
			for (int j = number -1 ; j > i; j--) {
				if (singer.get(i) > singer.get(j) && rightUp[j]+1 > max) {
					max = rightUp[j] + 1;
					
				}
			}
			rightUp[i] = max;
		}
		int max = 0;
		for (int i = 1; i < number-1; i++) {
			if (rightUp[i] + leftUP[i] > max) {
				max = rightUp[i] + leftUP[i];
			}
		}
		max--;
		if (leftUP[number-1] > max) max = leftUP[number-1];
		if(rightUp[0] > max) max = rightUp[0];
		System.out.println(number - max);
		
	}
}
