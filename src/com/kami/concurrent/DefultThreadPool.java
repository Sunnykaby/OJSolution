package com.kami.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
	
	//workder就是整个线程池的工作线程，实现runnable
	//静态常量用这种方式表示
	private static final int DEFULT_WORKDER_NUMBERS = 5;
	private static final int MAX_WORKDER_NUMBERS = 10;
	private static final int MIN_WORKER_NUMBERS = 1;
	//工作任务列表,FIFO 
	private final LinkedList<Job> jobs = new LinkedList<Job>();
	//工作线程列表，用syn方法实现，worker相当于线程的运行机制，一直在跑，等到着从工作队列中拿到工作任务，没有的就阻塞
	private final List<Worker> workers =  Collections.synchronizedList(new ArrayList<Worker>());
	//工作线程的数量，维护现在工作线程的数量
	private int workerNum = DEFULT_WORKDER_NUMBERS;
	//线程编号，方便线程打印名称
	private AtomicLong threadNum = new AtomicLong();
	
	public DefultThreadPool() {
		// TODO Auto-generated constructor stub
		//初始化工作线程，所谓的线程池就是在创建整个对象的时候在内部维护多个正在运行的线程，需要的话就能够将job进行执行
		initializeWorkers(DEFULT_WORKDER_NUMBERS);
	}
	
	
	
	//构造指定数量的工作线程
	public DefultThreadPool(int number){
		workerNum = number<=MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:number>MAX_WORKDER_NUMBERS?MAX_WORKDER_NUMBERS:number;
		initializeWorkers(workerNum);
	}
	//主要是将任务添加在任务队列中，这样后台的worker就会来取走这个job，一定要注意线程安全
	@Override
	public void excute(Job job) {
		// TODO Auto-generated method stub
		if (job!=null) {
			synchronized (jobs) {
				//为了形成FIFO
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}
	
	private void initializeWorkers(int number){
		for (int i = 0; i < number; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			//create thread to run the worker
			Thread thread =  new Thread(worker,"ThreadPoolWorker-"+threadNum.incrementAndGet());
			thread.start();
		}
	}
	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addWorkers(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			num = workerNum+num > MAX_WORKDER_NUMBERS?MAX_WORKDER_NUMBERS-this.workerNum:num;
			initializeWorkers(num);
			this.workerNum += num;
		}
		
		return true;
	}

	@Override
	public boolean removeWorkers(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if (num > this.workerNum) {
				num = this.workerNum;
			}
			int count = 0;
			while(count < num){
				
			}
		}
		
		
		return false;
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		
		return jobs.size();
	}

	
	class Worker implements Runnable{
		private volatile boolean running = true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//主要任务就是从人物队列中取到任务然后运行（不管死活，就是抛出异常的话就没戏了）
			//主要还提供了shutdown功能
			while(running){
				Job job = null;
				synchronized (jobs) {
					if (jobs.isEmpty()) {
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							// TODO: handle exception
							//将当前运行线程中断
							Thread.currentThread().interrupt();
							return;
						}
					}
					else {
						job = jobs.removeFirst();
					}
				}
				if (job!=null) {
					//job同时也是一个runnable类，直接调用run，不用线程去启动，因为本身就是在线程里
					try {
						job.run();
					} catch (Exception e) {
						// TODO: handle exception
						//do the exp from jod
					}
				}
			}
		}
		
		public void shutdown(){
			running = false;
		}
		
	}
}


