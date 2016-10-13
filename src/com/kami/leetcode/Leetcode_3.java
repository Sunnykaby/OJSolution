package com.kami.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Binary Tree Zigzag Level Order Traversal
 * @author shidian
 *
 */
public class Leetcode_3 {

	public int lengthOfLongestSubstring(String s) {
		if (s==null || s.length() == 0) {
			return 0;
		}
		int lastIndex = 0, maxLen = 0, curIndex = 0, curLength = 0;

		int length = s.length();
		char[] strings = s.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();//把hashmap替换成数组可能会更快一些。毕竟数组的查找更快
		for(curIndex = 0; curIndex < length; curIndex++){
			char temp = strings[curIndex];
			if (charMap.containsKey(temp) && charMap.get(temp) >= lastIndex) {//这里有一个小技巧，通过不用每次clean，只需要去判断是否在当前index之后即可（当时思路不清晰）
				lastIndex = charMap.get(temp)+1;
				curLength = curIndex - lastIndex + 1;
//				cleanMap(charMap, lastIndex);
			}
			else{
				maxLen = (++curLength) > maxLen?curLength:maxLen;
			}
			charMap.put(temp, curIndex);
		}
		return maxLen;
	}
	
	private void cleanMap(Map<Character, Integer> src, int target){
		Iterator<Entry<Character, Integer>> iterator = src.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Character, Integer> cur = iterator.next();
			if (cur.getValue() < target) {
				iterator.remove();
			}
		}
	}

	public static void main(String[] args){
		String src = "abcabccbbcdseeeedaaxs";
		Leetcode_3 cureClasss = new Leetcode_3();
		System.out.println(src.length() + " : " + cureClasss.lengthOfLongestSubstring(src) );
	}
}
