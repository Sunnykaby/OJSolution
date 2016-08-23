package com.kami.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class fortest {
	 public static  List<String> summaryRanges(int[] nums) {
		 List<String> result = new ArrayList<String>();
	        int start,end;
	        boolean sucessive = false;
	        int length = nums.length;
	        for(int i = 0; i < length; ){
	            int pre = nums[i];
	            start = i;
	            end = i;
	            for(int j = i+1; j <length;j++ ){
	                if(nums[j] == (pre+1)){
	                    end++;
	                    pre++;
	                    sucessive =false;
	                }
	                else {
	                    if(start == end) 
	                        result.add(nums[start]+"");
	                    else 
	                        result.add(nums[start]+"->" + nums[end]);
	                    sucessive = true;    
	                    break;
	                }
	            }
	            if(!sucessive){
	                if(start == end)
	                   result.add(nums[start]+"");
	                else if(start < end )
	                    result.add(nums[start] + "->" + nums[end]);	                     
	            }
	            sucessive = false;
	            i = end + 1;
	        }
	        return result;
	    }
	public static void main(String[] arg){
		int[] nums = {1,3};
		List<String> resultList = summaryRanges(nums);
		System.out.println(resultList);
		String a = new String("sdafasdfads");
		String bString = new String("sdafasdfads");
		char[] temmp = a.toCharArray();
		char[] temp2  = bString.toCharArray();
 		Arrays.sort(temmp);
 		Arrays.sort(temp2);
 		
 		System.out.println(new String(temmp));
 		System.out.println(new String(temp2));
 		if (new String(temmp).equals(new String(temp2))) {
			System.out.println("ok");
		}
		
	}
}
