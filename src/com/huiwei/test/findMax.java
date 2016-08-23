package com.huiwei.test;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Scanner;

public class findMax {
	 
	public static void main(String[] args){
			
		Scanner snScanner = new Scanner(System.in);
		while(snScanner.hasNext()){
			int number = snScanner.nextInt();
			int methodnum = snScanner.nextInt();
			ArrayList<Integer> score = new ArrayList<Integer>(100000);

			while(number > 0){
				score.add(snScanner.nextInt());
				number--;
			}
			snScanner.nextLine();
			while(methodnum>0){
				char quer = snScanner.next().charAt(0);
				if (quer=='Q') {
					int startInt = snScanner.nextInt();
					int endInd =  snScanner.nextInt();
					if (endInd>= score.size()) {
						endInd = score.size()-1;
					}
					if (startInt <= 0) {
						
					}
					else if (endInd < startInt) {
						
					}
					int max = 0;
					for (int i = startInt; i < endInd+1; i++) {
						if (score.get(i) > max) {
							max = score.get(i);
						}
					}
					System.out.println(max);
				}
				else if(quer=='U'){
					int index = snScanner.nextInt();
					int element = snScanner.nextInt();
					if (index>= score.size()) {
						index = score.size()-1;
					}
					
					
					if (index > score.size()-1) {
						
					}
					score.set(index, element);
				}
				methodnum--;
			}
		}	
	}
}
