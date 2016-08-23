package com.kami.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.huiwei.test.commandMatch;

public class leetcode_263 {
	/**
	 * only include prime factors 2,3,5;1 is ugly
	 * @Description: TODO
	 * @param @param num
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author 
	 * @date 2016年8月18日
	 */
	public boolean isUgly(int num) {
		while(num%2==0) {
			num = num/2;
		}
		while(num%3==0){
			num/=3;
		}
		while(num%5==0) num/=5;
		
		if (num ==1 ) {
			return true;
		}
		
		return false;
	}


	public static void main(String[] args){
		leetcode_263 temp = new  leetcode_263();
		System.out.println(temp.isUgly(201));
	}
}
