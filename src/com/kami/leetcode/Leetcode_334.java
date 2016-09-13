package com.kami.leetcode;


public class Leetcode_334 {
	public boolean increasingTriplet(int[] nums) {
		//this solution is O(n^2) and the space is O(n)
		if (nums.length < 3) {
			return false;
		}
		int[] prefix = new int[nums.length];//if the prefix is not itself, it means that there is a number before it and smaller than it.
		for (int i = 0; i < prefix.length; i++) {
			prefix[i] = i;//init the array elements to -1, because 0 is the first number
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (prefix[j] != j) {
						return true;
					}
					else if (prefix[i] == i) {
						prefix[i] = j;
					}
				}
			}
			
		}
		return false;
	}
	
	public boolean increasingTriplet2(int[] nums) {
		//this solution is O(n) and the space is O(1)
		if (nums.length < 3) {
			return false;
		}
		int min = Integer.MAX_VALUE, minLess = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			if (cur <= min) min = cur; //= avoid that the same min situation
			else if(cur < minLess) minLess = cur;
			else if(cur > minLess) return true;
		}
		return false;
	}
	public static void main(String[] args){
		int[] temp = new int[]{1, 9, 8, 7, 2};
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		Leetcode_334 tempL = new Leetcode_334();
		System.out.println(tempL.increasingTriplet2(temp));
	}
}
