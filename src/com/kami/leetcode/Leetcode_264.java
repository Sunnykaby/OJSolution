package com.kami.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.acmCoder.bestCoder.Main;
import com.huiwei.test.commandMatch;

public class Leetcode_264 {
	/**
	 * only include prime factors 2,3,5;1 is ugly, find the n th
	 * @Description: TODO
	 * @param @param n
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author 
	 * @date 2016年8月18日
	 */
	public int nthUglyNumber(int n) {
		int[] nUgly = new int[n];
		int _3 =  0, _2 = 0, _5 = 0;
		nUgly[0] = 1;
		for(int i = 1; i < n; i++){
			if (2*nUgly[_2] <= nUgly[i-1]) {
				_2++;//这一步相当于。如果之前选中了它作为下一个位置的因子，那么这个就++。
					//相当于先把下一个位置的数据存起来。然后再下一步的时候（在找到这个位置）将这个位置++(非常巧妙的一个想法)
			}
			if (3*nUgly[_3] <= nUgly[i-1]) {
				_3++;
			}
			if (5*nUgly[_5] <= nUgly[i-1]) {
				_5++;
			}
			nUgly[i] = Math.min(2*nUgly[_2], Math.min(3*nUgly[_3], 5*nUgly[_5]));
		}
		
 		return nUgly[n-1];
	}
	
	


	public static void main(String[] args){
		Leetcode_264 temp = new  Leetcode_264();
		System.out.println(temp.nthUglyNumber(201));
		
		//
		
		
		
		//
	}
}
