package com.kami.java;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapSyn {
	public static final int THREAD_POOL_SIZE = 5;
	public static final int TEST_RANGE = 500000;
	public static Map<Integer, Integer> synMap = null;
	public static Map<Integer, Integer> tableMap = null;
	public static Map<Integer, Integer> concMap = null;

	public static void testMapPerformance(final Map<Integer, Integer> targetMap) throws InterruptedException{
		System.out.println("this is a new Test for " + targetMap.getClass());
		long startTime = System.nanoTime();
		for(int i = 0; i < 5; i++){
			//cycle 5 times, get avg
			ExecutorService threadpools = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
			long inStartTime = System.nanoTime();
			for(int j = 0; j < THREAD_POOL_SIZE; j++){
				threadpools.execute(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(int m = 0; m < TEST_RANGE; m++){
							Integer randomInt =(int)(Math.random()*30000);
							targetMap.get(randomInt);
							targetMap.put(randomInt, randomInt);
						}
					}
				});
			}
			//ensure that all task is done
			threadpools.shutdown();
			threadpools.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			long inendTime = System.nanoTime();
			System.out.println("This part of threadPools cost " + (inendTime - inStartTime));
		}
		long endTime = System.nanoTime();
		System.out.println("The totaltime cost is " + (endTime-startTime) + ", and the avgTime is " + (endTime-startTime)/5);

	}


	public static void main(String[] args){
		try {
			synMap = Collections.synchronizedMap(new HashMap<>());
			testMapPerformance(synMap);

			tableMap = new Hashtable<>();
			testMapPerformance(tableMap);

			concMap = new ConcurrentHashMap<>();
			testMapPerformance(concMap);
		} catch (Exception e) {
			// TODO: handle exception
		}


	}
}


