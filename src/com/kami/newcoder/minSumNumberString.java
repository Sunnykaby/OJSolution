package com.kami.newcoder;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.huiwei.test.rebulitTree;

public class minSumNumberString {

	public String PrintMinNumber(int[] numbers) {
		ArrayList<String> numberList = new ArrayList<String>();
		int number = numbers.length;
		int i = 0;
		while (i < number) {
			numberList.add(Integer.toString(numbers[i++]));
		}
		Collections.sort(numberList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if ((o1+o2).compareTo(o2+o1) < 0) {
					return -1;
				}
				else return 1;
			}
			
		});
		StringBuilder sBuilder = new StringBuilder();
		i = 0;
		while(i < number){
			sBuilder.append(numberList.get(i++));
		}
		return sBuilder.toString();
	}
	
	public static void main(String[] args){
		String a = "abcd";
		int[] temp = {3,32,321};
		a = new minSumNumberString().PrintMinNumber(temp);
		System.out.println(a);
	}

}
