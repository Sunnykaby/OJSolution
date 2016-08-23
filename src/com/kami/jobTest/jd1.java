package com.kami.jobTest;

import java.util.Scanner;

public class jd1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int bear = in.nextInt();
		int sum;
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			sum = i;
			for (int j = 1; j <= bear; j++) {
				if (((sum * bear - 1 + bear) % (bear - 1)) == 0) {
					sum = (bear * sum - 1 + bear) / (bear - 1);
				} else
					break;
				if (j == bear) {
					System.out.println(sum);
					return;
				}
			}

		}
	}
}
