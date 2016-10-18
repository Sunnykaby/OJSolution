package com.kami.leetcode;
/**
 * Maximum Product Subarray
 * @author shidian
 *
 */
public class Leetcode_152 {
	public int maxProduct(int[] nums) {
		int maxResult = Integer.MIN_VALUE,lastResult = 1;
		for (int i = 0; i < nums.length; i++) {
			maxResult = Math.max(maxResult, lastResult*=nums[i]);
			if (nums[i] == 0) {
				lastResult = 1;
			}
		}
		lastResult = 1;
		for (int i = nums.length-1; i > 0; i--) {
			maxResult = Math.max(maxResult, lastResult*=nums[i]);
			if (nums[i] == 0) {
				lastResult = 1;
			}
		}
		return maxResult;
	}
}
