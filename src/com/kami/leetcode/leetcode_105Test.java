package com.kami.leetcode;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class leetcode_105Test {

	@Test
	public void test() {
		int number[] = {9,1,4,7,3,-1,0,5,8,-1,6};
		leetcode_105 newLeetcode_105 = new leetcode_105();
		
		int b = newLeetcode_105.longestConsecutive_better(number);
		Assert.assertEquals(7,newLeetcode_105.longestConsecutive(number));
	}
	

}
