package com.kami.java;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;


public class transferCrim {
	
	public static void main(String[] args){
		Scanner inScanner = new Scanner(System.in);
		int number = inScanner.nextInt();
		int thread = inScanner.nextInt();
		int transfer = inScanner.nextInt();
		int result = 0;
		Queue<Integer> crime = new LinkedList<Integer>();
		int sum = 0;
		while(number>0){
			int temp = 0;
			if(crime.size()<transfer){
				 temp = inScanner.nextInt();
				crime.offer(temp);
				sum+=temp;
				number--;
			}
			if (crime.size()==transfer) {
				if (sum<=thread) {
					result++;
				}
				temp = crime.poll();
				sum-=temp;
				temp = inScanner.nextInt();
				crime.offer(temp);
				sum+=temp;
				number--;
			}
		}
		if (crime.size()==transfer) {
			if (sum<=thread) {
				result++;
			}
		}
		System.out.println(result);
		
	}
}
