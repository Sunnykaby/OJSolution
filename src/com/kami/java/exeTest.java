package com.kami.java;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.kami.tree.TreeNode;


/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/


public class exeTest {
	public static void main(String[] args){
//		System.out.println("322".compareTo("323"));
//		int  a = 257;
//		System.out.println(a&0XFF);
		byte a = 2, b = 3, c,d;
		final byte x = 5, y = 6, z ,m;
//		z = a+b;
//		z = x+y;
//		z = a + x;
//		c = a + x;
		
//		Integer a = 145;
//		Integer b = 145;
//		System.out.println(a==b);
//		String tempString = "abcd\3";
//		Scanner scanner = new Scanner(System.in);
//		String inString = scanner.next();
//		System.out.println(inString.length());
//	char[] tempchar = tempString.toCharArray();
//	int ch = 0;
//	int i = 0;
//	while(tempchar[i] != '\0'){
//		System.out.print(tempchar[i]);
//		i++;
//	}
//	System.out.println(i);
//	System.out.println(tempchar.length);
//		System.out.println(tempString.length() +" " + tempString);
		
//		Map<String, String> temp = new HashMap<String, String>();
//		BigInteger a = new BigInteger("131413423");
		
		ExecutorService ecuExecutorService = new ThreadPoolExecutor(20, 50, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
//		
		ExecutorService executorService = Executors.newFixedThreadPool(10,new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				
				return new Thread();
			}
		});
	}
}
