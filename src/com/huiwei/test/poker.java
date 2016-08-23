package com.huiwei.test;

import java.util.Scanner;

public class poker {
	public static boolean judge(String a, String b){
		if (a.equals("2")) {
			return true;
		}
		else if (b.equals("2")) return false;
		else if(a.equals("A")) return true;
		else if(b.equals("A")) return false;
		else if(a.equals("10")){
			if(b.charAt(0)>'9') return false;
			else return true;
		}
		else if(b.equals("10")){
			if(a.charAt(0)>'9') return true;
			else return false;
		}
		else if(a.charAt(0) > b.charAt(0)) return true;
		else return false;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String pokerLineString = in.nextLine();
		String leftPokerString = pokerLineString.substring(0,pokerLineString.indexOf('-'));
		String rightPokerString = pokerLineString.substring(pokerLineString.indexOf('-')+1,pokerLineString.length());
		String[] leftPoker = leftPokerString.split(" ");
		String[] rightPoker = rightPokerString.split(" ");
		
		int leftPokerNum = leftPoker.length;
		int rightPojerNum = rightPoker.length;
		//double joker
		 if (leftPokerNum==2&&leftPoker[0].equals("joker")) {
			System.out.println(leftPokerString); 
			return;
		}
		 if(rightPojerNum == 2&& rightPoker[0].equals("joker")){
			 System.out.println(rightPokerString); 
				return;
		 }
		 if (rightPojerNum==4) {
			if (leftPokerNum==4) {
				if(judge(rightPoker[0], leftPoker[0])){
					System.out.println(rightPokerString);
					
				}
				else System.out.println(leftPokerString);
				
			}
			else System.out.println(rightPokerString);
			return;
		}
		 else if (leftPokerNum == 4) {
			System.out.println(leftPokerString);
			return;
		}
		 if (leftPokerNum==rightPojerNum) {
			 if(judge(rightPoker[0], leftPoker[0])){
					System.out.println(rightPokerString);
					
				}
				else System.out.println(leftPokerString);
		}
		 else{
			 System.out.println("ERROR");
		 }
		 
		 
		
		
	}
}
