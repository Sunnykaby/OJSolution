package com.kami.leetcode;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {
	//	public int[] twoSum(int[] nums, int target) {
	//		int[] tempArray = nums.clone();
	//		int[] result = new int[2];
	//		Arrays.sort(nums);
	//		for (int i = 0; i < nums.length; i++) {
	//			int temp = findTarget(nums, target-nums[i], i);
	//			if( temp != -1){
	//				result[0] = Arrays.binarySearch(tempArray, nums[i]);
	//				//remove the num, avoid the same one
	//				Arrays.
	//				//
	//				result[1] = Arrays.binarySearch(tempArray, nums[temp]);
	//				break;
	//			}
	//		}
	//		return result;
	//	}
	//
	//	public int findTarget(int[] nums, int target, int position){
	//		int start = position+1, end = nums.length-1,middle = 0;
	//		while(start <= end){
	//			middle = start+(end-start)/2;// avoid out of range of integer
	//			if (nums[middle] == target) {
	//				return  middle;
	//			}
	//			else if(nums[middle] < target){
	//				start = middle+1;
	//			}
	//			else{
	//				end = middle-1;
	//			}
	//		}
	//		return -1;
	//	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numList = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			int otherTarget = target - temp;
			if (numList.containsKey(otherTarget)) {
				return new int[]{i,numList.get(otherTarget)};
			}
			numList.put(temp, i);
		}
		return new int[]{0,0};
	}

	public static void main(String[] args){
		int[] src = {0,4,3,0};
		Leetcode_1 tempOj = new Leetcode_1();
		System.out.println(tempOj.twoSum(src, 0)[0]);
		System.out.println(tempOj.twoSum(src, 0)[1]);
	}
}
