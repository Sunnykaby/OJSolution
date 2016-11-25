package com.kami.string;

import static org.hamcrest.CoreMatchers.instanceOf;

public class StringUtils {

	/**
	 * 最长递增子序列-方法一（DP）
	 * @param src
	 * @return
	 */
	public int LongestAscendSubstring(String src){
		int result = 0;
		if (src== null||src.equals("")) {
			result = 0;
		}
		else{
			int srcLength = src.length();
			int subStringLength = 0;
			int[] prefixs = new int[srcLength];
			int[] longest = new int[srcLength];
			int tempMax = 0;
			char[] strings = src.toCharArray();
			prefixs[0] = strings[0];
			longest[0] = 1;
			for (int i = 1; i < strings.length; i++) {
				tempMax = 1;
				char cur = strings[i];
				longest[i] = 1;
				prefixs[i] = i;
				for (int j = 0; j < 1; j++) {
					if (cur > strings[j]) {
						if((longest[j]+1) > tempMax) {
							tempMax = longest[j]+1;
							prefixs[i] = j;
							longest[i] = tempMax;
						}
					}
				}
			}
			result = longest[srcLength-1];
		}
		return result;
	}
	
	/**
	 * 最长递增子序列-方法二（优化DP）
	 * @param src
	 * @return
	 */
	public int LongestAscendSubstring2(String src){
		int result = 0;
		if (src== null||src.equals("")) {
			result = 0;
		}
		else{
			int srcLength = src.length();
			int subStringLength = 0;
			char[] longest = new char[srcLength];
			char[] chs = src.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				int index = findBetween(longest, chs[i]);
				longest[index+1] = chs[i];//need to check?
			}
			int index = 0;
			while(longest[index++] < 'a');
			return index-1;
		}
		return result;
	}
	
	/**
	 * 在数组中寻找比target最接近的最小值（A < target < B）
	 * @param src
	 * @param target
	 * @return A 
	 */
	public int findBetween(char[] src, char target){
		
		if (src.length ==0) {
			return 0;
		}
		int start = 0;
		int end = src.length-1;
		int length = src.length;
		while(start < end){
			int middle = start + (end-start)/2;
			if (src[middle] < target) {
				start = middle+1;
			}
			else if(src[middle] > target) end = middle-1;
			else break;
		}
		if (src[start]==target) {
			return start;
		}
		else if(src[start] < target){
			while(start<length-1 && src[++start] < target);
			return start;
		}
		else {
			while(start>0 && src[--start] > target);
			return start;
		}
	}
	
	
	
}
