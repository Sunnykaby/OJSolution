package com.kami.leetcode;


public class ReverseInteger {
	public int reverse(int x) {
        long temp = x;
        if(x < 0 ) temp = temp*-1;
        
        StringBuilder strin= new StringBuilder(Long.toString(temp));
			strin = strin.reverse();
			if(x < 0) temp = Long.parseLong(strin.toString())*-1;
			else  temp = Long.parseLong(strin.toString());
			if(temp != (int)temp) temp = 0;
			return (int)temp;
        
    }
	public static void main(String[] args){
		System.out.println(new ReverseInteger().reverse(-1000000));
		String aString = "a asd f";
	}
}
