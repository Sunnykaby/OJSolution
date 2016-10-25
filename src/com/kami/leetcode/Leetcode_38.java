package com.kami.leetcode;
//38. Count and Say
public class Leetcode_38 {
	public String countAndSay(int n) {
        if(n <=0) return "";
        String result = "1";
        int count = 1;
        while(count < n){
            char[] temp = result.toCharArray();
            int ch = temp[0];
            int countCh = 0;
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < temp.length; i++){
                if(temp[i] == ch) countCh++;
                else {
                    sb.append(countCh + "" + (ch-'0'));
                    countCh = 1;
                    ch = temp[i];
            }
            }
            sb.append(countCh + "" + (ch-'0'));
            result = sb.toString();
            count++;
        }
        return result;
    }
	
	public static void main(String[] args){
		Leetcode_38 temp = new Leetcode_38();
		System.out.println(temp.countAndSay(10));
	}
}
