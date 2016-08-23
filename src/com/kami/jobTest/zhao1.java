package com.kami.jobTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
class A {
	private B b;
	private C c;
	int a;
	 short d;
}
class B{
	
}
class C{
	
}
public class zhao1 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> countMap = new LinkedHashMap<String, Integer>();
		while(in.hasNext()){
			String temp = in.nextLine().trim();
			if (countMap.containsKey(temp)) {
				countMap.put(temp, countMap.get(temp)+1);
			}
			else countMap.put(temp, 1);
		}
		for (Entry<String, Integer> temp : countMap.entrySet()) {
			System.out.println(temp.getKey()+":"+temp.getValue());
		}
	}
}
