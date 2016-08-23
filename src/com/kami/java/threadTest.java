package com.kami.java;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


 class threadTesta  extends Thread{
   private int count = 	10;
   public void run(){
	   for (int i = 0; i < 100; i++) {
		   
		if(count >=0) {
			
			System.out.println(Thread.currentThread() + new Integer(count).toString()); 
			count -- ;
			}
	}
	   
   }
   public String toString(){
	   return Thread.currentThread().toString() + this.count;
   }
}


public class threadTest {
	public static void main(String[] args){
		threadTesta newTest = new threadTesta();
		new Thread(newTest,"this is a 1").start();
		new Thread(newTest,"this is a 2").start();
		ExecutorService executorService = Executors.newCachedThreadPool();
		
	}
}