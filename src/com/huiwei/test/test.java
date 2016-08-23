package com.huiwei.test;

import java.util.Scanner;
import java.util.regex.Pattern;

import javax.sound.midi.Patch;

public class test {
	public String formatString(String sourceString) {
		sourceString = sourceString.trim();
		sourceString = sourceString.replaceAll("\\s+", " ");
        return sourceString;
}
	public static void main(String[] args){
		String a = "asdfas sadfas";
//		String b = "asdfas sadfas" ;
//		System.out.println(a.equals(b));
//		a = "j j j j";
//		
//		char[] temp = a.replace(" ", "").toCharArray();
//		System.out.println(temp.length);
//		Scanner scanner = new Scanner(System.in);
//		while(scanner.hasNext()){
//			
//		}
//		System.out.println("break out");
		test ta = new test();
		a = ta.formatString("  asdfa   asdas  adsa asd a  ");
		System.out.println(a);
		
	}
}
