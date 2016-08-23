package com.kami.concurrent;

public interface ThreadPool<Job extends Runnable> {
	//执行job
	void excute(Job job);
	//关闭线程池
	void shutdown();
	//添加工作线程
	boolean addWorkers(int num);
	//减少工作线程
	boolean removeWorkers(int num);
	//获得等待执行的工作数量
	int getJobSize();
}
