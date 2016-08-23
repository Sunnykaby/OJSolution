package com.kami.jobTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class didi {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		int a = 10;
		while(a-->0){
			num.add(in.nextInt());
		}
		if(num.size() == 0) {
        	System.out.println();
        	return;
        }
		//HashMap<Integer, Integer> indexHashMap = new HashMap<Integer, Integer>();
		int max = 0;
		int tempLen = 0;
		int sum = 0;
		
		int start = -1, end = -1,tempstart = 0,tempend = 0;
		for (int i = 0; i < num.size(); i++) {
			tempLen = 0;
			tempstart = i;
			tempend = i;
			sum = 0;
			for (int j = i; j < num.size(); j++) {
				if ((sum+=num.get(j)) == 0) {
					tempLen=j-i;
					tempend = j;
				}
				
			}
			if(max<tempLen){
				start = tempstart;
				end = tempend;
				max = tempLen;
			}
		}
		if (start == -1|| end == -1) {
			System.out.println();
			return;
		}
		while(start <= end ){
			System.out.print(num.get(start) + " ");
			start++;
		}
		System.out.println();
		return;
		
	}
}
