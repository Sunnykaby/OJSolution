package com.kami.leetcode;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		//该处可以利用DP来进行求解,需要回溯，所以创建两个数组
		int length = nums.length;
		if (length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> result = new ArrayList<Integer>();
		Arrays.sort(nums);// sort the array
		int[] pre = new int[length];// store the pre index of best solution
		int[] bestLength = new int[length];
		int maxIndex = 0;//记录最大值的index
		for(int i = 0; i < length; i++){
			bestLength[i] = 1;
			pre[i] = i;
			for(int j =0; j < i; j++){
				if (nums[i]%nums[j]==0 && bestLength[j] + 1 > bestLength[i]) {
					bestLength[i] = bestLength[j] + 1;
					pre[i] = j;
				}
			}
			if (bestLength[i] > bestLength[maxIndex]) {
				maxIndex = i;
			}
		}
		if (bestLength[maxIndex] >0) {
			int i = maxIndex;
			while(pre[i] != i){
				result.add(nums[i]);
				i = pre[i];
			}
			result.add(nums[i]);
		}
		return result;
		
	}

	public static void main(String[] args){
		int[] nums = {3,2,16,24,96,192,576,12,6};
		Leetcode_368 leetcode_368 = new Leetcode_368();
		System.out.println(leetcode_368.largestDivisibleSubset(nums));
		
	}
}
