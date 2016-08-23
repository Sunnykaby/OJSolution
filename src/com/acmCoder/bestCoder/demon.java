package com.acmCoder.bestCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demon {
	
	public static char FindFirstNotRepeat(String str){  
        if(str == null){  
            return ' ';  
        }   
        int[] hash = new int[256];  
        //初始化hash数组  
        for(int i =0;i<hash.length;i++){  
            hash[i]=0;  
        }  
        for(int i =0;i<str.length();i++){  
            hash[str.charAt(i)] ++;  
              
        }  
        for(int i=0;i<str.length();i++){  
            if(hash[str.charAt(i)] == 1)  
                return str.charAt(i);  
        }  
        return ' ';  
    }  
	public static void main(String args[]) {
		
	BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));
	try {
		int number = Integer.parseInt(brBufferedReader.readLine().trim());
		while(number > 0){
			String currentString = brBufferedReader.readLine();
			int[] IndexChar = new int[256];
			int[] Index = new int[256];
			for(int i =0;i<256;i++){  
	            Index[i]=0;  
	            IndexChar[i] = 0;
	        }  
	        for(int i =0;i<currentString.length();i++){  
	        	int curChar = currentString.charAt(i);
	        	if (IndexChar[curChar] == 0) {
					Index[curChar] = i;
				}
	            IndexChar[currentString.charAt(i)] ++;  
	              
	        }  
	        char temp = ' ';
	        for (int i = 0; i < IndexChar.length; i++) {
				int j = IndexChar[i];
				if (j == 1) {
					temp = currentString.charAt(Index[i]);
					break;
				}
				
			}
	        System.out.println(temp);
			number--;
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
}

