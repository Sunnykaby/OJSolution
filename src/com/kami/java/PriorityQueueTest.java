package com.kami.java;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args){
		PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
		
		temp.add(1);
		temp.add(2);
		temp.add(2);
		temp.add(10);
		temp.add(5);
		System.out.println(temp.peek());
		System.out.println(temp.poll());
		while(!temp.isEmpty()){
			System.out.println(temp.poll());
		}
		
		temp.offer(1);
		temp.offer(2);
		temp.offer(10);
		temp.offer(5);
		System.out.println(temp.peek());
		System.out.println(temp.poll());
		while(!temp.isEmpty()){
			System.out.println(temp.poll());
		}
	}
}
