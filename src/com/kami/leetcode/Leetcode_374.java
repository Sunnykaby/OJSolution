package com.kami.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_374 {
	private static int number = 1702766719;
	
	private int guess(int num){
		return num<number?(1):(num==number?0:-1);
	}
	//初步考虑折半查找
	public int guessNumber(int n) {
		int _from = 1,_to = n;
		int temp = 0;
		while(_from < _to){
			int middle = _from + (_to -_from)/2;//防止溢出
			temp=guess(middle);
			if (temp == 0) {
				return middle;
			}
			else if (temp > 0) {
				_to = middle-1;
			}
			else {
				_from = middle+1;
			}
		}
		return _from;//一定存在？
	}

	public static void main(String[] args){
		Leetcode_374 temp = new Leetcode_374();
		System.out.println(temp.guessNumber(2126753390));
	}


}
