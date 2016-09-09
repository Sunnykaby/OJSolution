package com.kami.leetcode;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE,sum = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			//duplicate numer pass
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int start= i+1,end = nums.length-1;
			
			while(start < end){
				int tempSum = nums[i] + nums[start] + nums[end];
				if (target < tempSum)  {
					if (( tempSum - target) < minDiff) {
						minDiff=tempSum - target;
						sum = tempSum;
					}
					end--;
				}
				else if(target > tempSum){
					if ((target - tempSum) < minDiff) {
						minDiff = target - tempSum;
						sum = tempSum;
					}
					start++;
				}
				else return target;
			}
		}	
		return sum;
	}
	public static void main(String[] args){
		int[] src = {-1,2 ,1 ,-4};
		Leetcode_16 tempOj = new Leetcode_16();
		System.out.println(tempOj.threeSumClosest(src, 1));
	}
}
