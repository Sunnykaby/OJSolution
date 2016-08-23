package com.huiwei.test;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class beautyWords {
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		int number = scanner.nextInt();
		while(number>0){
			String word = scanner.nextLine();
			if (word.equals("")) {
				continue;
			}
			char[] sortword = word.toCharArray();
			
			Arrays.sort(sortword);
			word = new String(sortword);
			int legthS = word.length();
			ArrayList<Integer> numberList = new ArrayList<Integer>();
			int index = 0;
			char charString = word.charAt(0);
			int sum = 0;
			int max = 26;
			while(true){
				index = word.lastIndexOf(charString);
				numberList.add(word.lastIndexOf(charString) - word.indexOf(charString)+1);
				if (index == (legthS-1)) {
					break;
				}
				charString = word.charAt(index+1);
			}
			Collections.sort(numberList,Collections.reverseOrder());
			for (Integer integer : numberList) {
				sum+=max*integer;
				max--;
			}
			System.out.println(sum);
			number--;
		}
	}
}
