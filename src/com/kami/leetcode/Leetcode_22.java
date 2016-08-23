package com.kami.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_22 {
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		//避免string创建带来的空间和时间开销，使用char数组代替
		char[] currentString = new char[n*2];
		addPair(result, 0, n*2, 0, currentString);
		return result;
 	}
	
	public void addPair(List<String> result, int currentLength, int length,int sum, char[] currentString){
		
		if (currentLength == length && sum == 0) {
			result.add(new String(currentString));
			return;
		}
		if(currentLength < length){
			if (sum==0) {
				currentString[currentLength] = '(';
				addPair(result, currentLength+1, length, sum+1, currentString);
			}
			else if (sum > 0) {
				currentString[currentLength] = '(';
				addPair(result, currentLength+1, length, sum+1, currentString);
				currentString[currentLength] = ')';
				addPair(result, currentLength+1, length, sum-1, currentString);
			}
		}
	}

	public static void main(String[] args){
		Leetcode_22 leetcode_22 = new Leetcode_22();
		System.out.println(leetcode_22.generateParenthesis(3));
	}
}
