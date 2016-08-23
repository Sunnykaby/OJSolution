package com.kami.concurrent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import com.kami.concurrent.ConnectionPool;




//test , imitate the client to request,using,release the connection, and count the result TPS
// n thread to request m times, count the result of this pool
public class ConnectionPoolTest {
	static ConnectionPool pool = new ConnectionPool(10);
	//ensure all the thread can start together
	static CountDownLatch start = new CountDownLatch(1);
	//ensure all the thread end to show the results
	static CountDownLatch end;
	
	
	public static void main(String[] args) throws InterruptedException {
		int threadCount = 20;
		end = new CountDownLatch(threadCount);
		AtomicInteger success = new AtomicInteger();
		AtomicInteger failure = new AtomicInteger();
		for (int i = 0; i < threadCount; i++) {
			new Thread(new ConnectionThread(20, success, failure),"ConnectionThread" + i).start();
		}
		start.countDown();
		end.await();
		System.out.println("Connection total:" + threadCount*20);
		System.out.println("Connection fetch success:" + success);
		System.out.println("Connection fetch failure:" + failure);
	}
	
	//inner class,if this class is not static, we should new ConenctionPoolTest obj to create this class
	static class ConnectionThread implements Runnable{
		int count;
		AtomicInteger success;//ensure the concurrency
		AtomicInteger failure;
		public ConnectionThread(int count, AtomicInteger success, AtomicInteger failure) {
			this.count = count;
			this.success = success;
			this.failure = failure;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				start.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(count > 0){
				try {
					Connection temp = pool.fetchConnection(1000);
					if (temp != null) {
						try {
							temp.createStatement();
							temp.commit();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally{
							pool.releaseConnection(temp);
							success.incrementAndGet();
						}
					}
					else failure.incrementAndGet();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					--count;
				}
			}
			end.countDown();
		}
		
	}
}
