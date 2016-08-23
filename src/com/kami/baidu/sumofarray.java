package com.kami.baidu;

import java.util.Scanner;

public class sumofarray {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		while(sn.hasNext()){
			double start = sn.nextInt();
			int number = sn.nextInt();
			double sum = start;
			while(--number > 0){
				start = Math.sqrt(start);
				sum+=start;
			}
			
			System.out.printf("%.2f",sum);
		}
	}
}
