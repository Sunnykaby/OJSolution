package com.kami.leetcode;

public class Leetcode_134_Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;// total sum
		int start = gas.length-1, end = 0;
		//init the start - end(the start can be anyone, but this is better)
		total = gas[start] - cost[start];
		while(start > end) {
			if (total < 0) {
				--start;
				total+= gas[start] - cost[start] ;
			}
			else {
				total += gas[end] - cost[end];
				++end;
			}
		}
		return total < 0 ? -1:start;
	}
	
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int total = 0;// total sum
		int diffSum = 0;
		int start = 0;
		//init the start - end(the start can be anyone, but this is better)
		for (int i = 0; i < gas.length; i++) {
			if (diffSum < 0) {
				start = i;
				diffSum = gas[i] -cost[i];
			}
			else {
				diffSum +=gas[i] - cost[i];
			}
			total += gas[i] - cost[i];
		}
		return total < 0 ? -1:start;
	}
	
	public static void main(String[] args){
		
	}
}
