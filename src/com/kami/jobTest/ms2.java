package com.kami.jobTest;

import java.util.HashMap;
import java.util.Scanner;

public class ms2 {
	
	public static void main(String[] args){
		HashMap<Integer, Integer> fibMap = new HashMap<Integer, Integer>();
		int[] fib = new int[30];
		fib[0] = fib[1] = 1;
		for (int i = 2; i < 30; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		long sum[] = new long[30];
		for (int i = 0; i < sum.length; i++) {
			sum[i] = 0;
			fibMap.put(fib[i], i);
		}
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int temp = 0;
		Integer index;
		int tempnumber = num;
		while(tempnumber > 0){
			temp = in.nextInt();
			
			index = fibMap.get(temp);
			if (index == null) {
				tempnumber--;
				continue;
			}
			if (temp == 1) {
				sum[1] = (sum[1] + sum[0])%1000000007;
				sum[0] += 1;
				
			}
			else{
				sum[index] =(sum[index]+ sum[index-1])%1000000007;
			}
			tempnumber--;
		}
		long total = 0;
		for (int i = 0; i < 30; i++) {
			total = (sum[i]+total)%1000000007;
		}
		System.out.println(total);
		
	}
}
