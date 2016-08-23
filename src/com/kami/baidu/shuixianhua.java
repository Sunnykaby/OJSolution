package com.kami.baidu;

import java.util.Scanner;

public class shuixianhua {
	public static void main(String[] args){
		Scanner snScanner = new Scanner(System.in);
		while(snScanner.hasNext()){
			int start = snScanner.nextInt();
			int end = snScanner.nextInt();
			int count = 0;
			for (int i = start; i < end; i++) {
				int ge = i%10;
				int shi = (i%100)/10;
				int bai = i/100;
				if ((ge*ge*ge+shi*shi*shi+bai*bai*bai)==i ) {
					System.out.print(i+" ");
					count++;
				}
				
			}
			if (count == 0) {
				System.out.println("no");
			}
			else System.err.println();
		}
	}
}
