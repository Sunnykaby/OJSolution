package com.kami.java;
import java.util.Scanner;


public class thinkingInJava {
	public int countNumberOne(int number){
		int count = 0;
		char[] numberarray = String.valueOf(number).toCharArray();
		for (int i = 0; i < numberarray.length; i++) {
			if (numberarray[i] == '1') {
				count++;
			}
		}
		return count;
	}
	public int countOne(int number){
		int result = 0;
		for (int i = 1; i <= number; i++) {
			result+= countNumberOne(i);
		}
		return result;
	}
	
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		thinkingInJava athinkingInJava = new thinkingInJava();
		System.out.println(athinkingInJava.countOne(number));
	}
}
