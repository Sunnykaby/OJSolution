package com.kami.leetcode;

import static org.hamcrest.CoreMatchers.instanceOf;

public class Leetcode_80 {
	public int removeDuplicates(int[] nums) {
		int lastIndex = 0, currentLenth = 1;
		int newLength = nums.length;//用subtract，减少次数
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]==nums[lastIndex]) {
				currentLenth++;
				if (currentLenth > 2) {
					newLength--;
				}
				else{
					nums[++index] = nums[i]; 
				}
			}
			else {
				nums[++index] = nums[i]; 
				currentLenth = 1;
			}
			lastIndex++;
			
		}
		return newLength;
	}
	
	public int removeDuplicates2(int[] nums){
		int index = 0;
		for(int temp : nums){
			if (index  < 2 || temp > nums[index-2]) {
				nums[index++] = temp;
			}
		}
		return index;
	}

	public static void main(String[] args){
		int[] src = {0,4,3,0};
		Leetcode_80 tempOj = new Leetcode_80();
		System.out.println();
	}
}
