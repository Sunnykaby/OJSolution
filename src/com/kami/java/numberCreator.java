package com.kami.java;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Generated;


class Creator{
	OutputStream outputStream ;
	public Creator(OutputStream out) {
		// TODO �Զ����ɵĹ��캯�����
		outputStream = out;
	}
	public OutputStream getOutputStream(){
		return outputStream;
	}
}

class NumberGenerator {
	private FileWriter fileWriter;
	private StringBuffer bf = new StringBuffer();
	public NumberGenerator(String filename, Boolean flag){
		try {
			fileWriter = new FileWriter(filename,flag);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public boolean  Generated(int number){
		//int temp = (int)System.currentTimeMillis();
		int tempnumber = 2*number;
		Random numberRandom = new Random(10000);
		while(number>0){
			try {
				//System.out.println(numberRandom.nextLong());
				bf.append(Math.abs(numberRandom.nextInt(tempnumber))).append(" ");
				fileWriter.write(bf.toString());
				bf.setLength(0);
				number--;
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	
	public   boolean GeneratedNotRepeat(int number){
		Set<Long> numberSet = new HashSet<Long>();
		Random numberRandom = new Random(System.currentTimeMillis());
		//StringBuffer bfBuffer = null;
		while(number>0){
			numberSet.add(Math.abs(numberRandom.nextLong()));
		}
		Iterator<Long> setIt = numberSet.iterator();
		while(setIt.hasNext()){
			bf.append(setIt.next()).append(" ");
			try {
				fileWriter.write(bf.toString());
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
			bf = null;
		}
		return true;
	}
}
public class numberCreator {
	public static void main(String[] args){
		Scanner saca = new Scanner(System.in);
		int number = saca.nextInt();
		NumberGenerator ngGenerator;
		if (number <= 0 ) {
			System.out.println("Please input a plus number");
		}
		else {
			System.out.println("\nPlease input the filename:");
			String filenameString = saca.next();
			System.out.println("\nPlease input a appeand flag:");
			String flagString = saca.next();
			ngGenerator = new NumberGenerator(filenameString, false);
			ngGenerator.Generated(number);
		}
	}
	
}
