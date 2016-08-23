package com.kami.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		List<Character> srCharacters = new ArrayList<Character>() ;
        for (Character character : ransomNote.toCharArray()) {
			srCharacters.add(character);
		}
        List<Character> dest  = new ArrayList<Character>();
        for(Character temp : magazine.toCharArray()){
        	dest.add(temp);
        }
        if (dest.containsAll(srCharacters)) {
			Map<Character, Integer> srcMap = new HashMap<Character, Integer>();
			Map<Character, Integer> destMap = new HashMap<Character, Integer>();
			for(Character temp : srCharacters){
				if (srcMap.containsKey(temp)) {
					srcMap.put(temp, srcMap.get(temp)+1);
				}
				else srcMap.put(temp, 1);
			}
			for(Character temp : dest){
				if (destMap.containsKey(temp)) {
					destMap.put(temp, destMap.get(temp)+1);
				}
				else destMap.put(temp, 1);
			}
			
			for(Character temp : srcMap.keySet()){
				if (destMap.get(temp) < srcMap.get(temp)) {
					return false;
				}
			}
		}
        else {
			return false;
		}
        return true;
	}
	public boolean canConstruct2(String ransomNote, String magazine) {
		int[] dest = new int[26];//其实这个地方有一个小小的浪费，因为不一定会有全部的字母出现
		for(int i = 0; i < magazine.length(); i++){
			dest[magazine.charAt(i)-'a']++;
		}
		for(int i = 0; i < ransomNote.length(); i++){
			if (--dest[ransomNote.charAt(i)-'a'] < 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args){
		String src = "aa",deString="ab";
		leetcode_383 temp = new leetcode_383();
		System.out.println(temp.canConstruct2(src, deString));
	}
	

}
