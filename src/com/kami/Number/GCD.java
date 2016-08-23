package com.kami.Number;

public class GCD {
	public long findGCD(long a, long b){
		if (a%b == 0) return b;
		if (b%a == 0) return a;
		return a>=b?findGCD(b, a%b):findGCD(a, b%a);
	}
	public long findLCM(long a, long b){
		long gcd = findGCD(a, b);
		return a*b/gcd;
	}
	
	public static void main(String[] args){
		GCD gcd = new GCD();
		System.out.println(gcd.findGCD(12312, 234));
		System.out.println(gcd.findLCM(12312, 234));
	}
}
