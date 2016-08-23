package com.kami.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.management.modelmbean.DescriptorSupport;

class InputClass{
	static private String inputString = "";
	static public void input(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputString = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public int getInput(){
		input();
		return Integer.parseInt(inputString);
	}
	
}
class Result{
	void printResult(int temp){
		System.out.println(temp*temp);
		System.out.println(temp+temp);
	}
}


class BinaryJarged{
	static public boolean isBinaryNumber(int number){
		if (number == 0 || (number&(number-1)) == 0) {
			return true;
		}
		else return false;
	}
}

 class fibonacci{
	int count = 0;
	public long getInput(){
		Scanner inputScanner = new Scanner(System.in);
		return inputScanner.nextLong();
	}
	public long finNum(long n){
		if (n==0||n==1) {
			count++;
			return n;
		}
		else {
			return finNum(n-1) + finNum(n-2);
		}
	}
}
class dealString{
	private String tmep;
	public void setTemp(String temp){
		this.tmep = temp;
	}
	
	public void dealWithString(){
		if (tmep == null) {
			return;
		}
		char[] charArray = tmep.toCharArray();
		ArrayList sortList = new ArrayList();
		TreeSet noRepeatString = new TreeSet();
		for (int i = 0; i < charArray.length; i++) {
			sortList.add(String.valueOf(charArray[i]));
			noRepeatString.add(String.valueOf(charArray[i]));
		}
		Collections.sort(sortList);
		StringBuffer sortedStringBuffer =  new StringBuffer(); 
		for (int i = 0; i < sortList.size(); i++) {
			sortedStringBuffer.append(sortList.get(i));
		}
		String inputString = sortedStringBuffer.toString();
		String maxString = "";
		int max = 0;
		ArrayList maxList = new ArrayList();
		
		Iterator its = noRepeatString.iterator();
		while(its.hasNext()){
			String os = (String)its.next();
			int start = inputString.indexOf(os);
			int end = inputString.lastIndexOf(os);
			int l = end- start +1;
			if (l > max) {
				maxString = os;
				max = l;
				maxList.add(os);
			}
			else if (l == max ) {
				maxList.add(os);
			}
		}
		
		int indexMax = 0;
		for (int i = 0; i < maxList.size(); i++) {
			if (maxList.get(i).equals(maxString)) {
				indexMax = i;
				break;
			}
		}
		
		for (int i = indexMax; i < maxList.size(); i++) {
			System.out.println(maxList.get(i));
		}
		
	}
}
public class JavaTest implements Serializable{
	public static void main(String arg[]){
//		Result tempResult = new Result();
//		System.out.println("input a number");
//		
//		
//		int temp = InputClass.getInput();
//		if(BinaryJarged.isBinaryNumber(temp)){
//			System.out.println("this is a 2 de beishu.");
//		}
//		else System.out.println("not a 2 beishu");
		
//		String[] arrayStrings = new String[]{"2","3","4","5"};
//		listALl(Arrays.asList(arrayStrings), "");
		
//		fibonacci finFibonacci = new fibonacci();
//		long number  = finFibonacci.getInput();
//		System.out.println(finFibonacci.finNum(number));
		List tempa = new ArrayList<Object>();
		Set tempb = new HashSet<Object>();
		for (int i = 0; i < 10; i++) {
			tempa.add(null);
		}
		for (int i = 0; i < 10; i++) {
			tempb.add(null);
		}
		
		for (int i = 0; i < tempa.size(); i++) {
			if (tempa.get(i)==null) {
				System.out.println("This is a null");
			}
		}
		System.out.println();
		for (Iterator iterator = tempb.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object==null) {
				System.out.println("This is a null");
			}
		}
		dealString dsDealString = new dealString();
		dsDealString.setTemp("ashdjashgkfaghiwhgjkasngkahsghdsjkdjadhgogiajsnva");
		//dsDealString.setTemp("abcdbdbabcaca");
		dsDealString.dealWithString();
	}
	
	
	
	public static void listALl(List tempList, String prefix){
			System.out.println(prefix);
			for (int j = 0; j < tempList.size(); j++) {
				List temp  = new LinkedList(tempList);
				listALl(temp, prefix+temp.remove(j)); 
				
			}
			"abd".length();
			
	}
	
}
