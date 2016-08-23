package com.kami.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.huiwei.test.commandMatch;

public class leetcode_105 {
	public int longestConsecutive(int[] nums) {
       Arrays.sort(nums);
       int longest = 1;
       int max = 1;
       int pre = nums[0];
       for (int i = 1; i < nums.length; i++) {
		if (nums[i] == pre) {
			continue;
		}
		else if (nums[i] == (pre+1)) {
			max++;
			longest = max>longest?max:longest;
			
		}
		else {
			max = 1;
			
		}
		pre = nums[i];
	}
       return longest;
    }
	
	public int longestConsecutive_better(int[] nums) {
	      Map<Integer, Integer> max_min = new HashMap<Integer, Integer>();
	      Set<Integer> repeatedList = new HashSet<Integer>();
	      int max = 0;
	      int min = 0;
	      int longest = 0;
	     for (int i = 0; i < nums.length; i++) {
	    	 int temp = nums[i];
			if (repeatedList.contains(temp)) {
				continue;
			}
			repeatedList.add(temp);
			min = max  =temp;
			if (max_min.containsKey(temp+1)) {
				max = max_min.get(temp+1);
				max_min.remove(max);
				max_min.remove(temp+1);
				
				
				
			}
			if (max_min.containsKey(temp-1)) {
				min = max_min.get(temp-1);
				max_min.remove(min);
				max_min.remove(temp-1);
				
			}
			
			longest = (max-min+1)>longest?(max-min+1):longest;
			max_min.put(min, max);
			max_min.put(max, min);
			
		}
	     return longest;
	
	}
	
	
	public static void main(String[] args){
		int number[] = {9,1,4,7,3,-1,0,5,8,-1,6};
		leetcode_105 newLeetcode_105 = new leetcode_105();
		int a = newLeetcode_105.longestConsecutive(number);
		int b = newLeetcode_105.longestConsecutive_better(number);
		System.out.println(b + " " + a);
	}
}
