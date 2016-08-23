package com.kami.java;
import java.awt.List;
import java.net.CookieHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import com.huiwei.test.rebulitTree;



class Order{
	public enum State{
		ORDER,CHECKED
	}
	private final int orderId;
	private final int userMoney;
	private State state = State.ORDER; 
	public  Order(int id,int money) {
		// TODO Auto-generated constructor stub
		//默认一个user只能定义
		orderId = id;
		userMoney = money;
	}

	public void check(){
		state = State.CHECKED;
	}
	public int getId(){
		return orderId;
	}
	public int getMoney(){
		return userMoney;
	}
	public State getState(){
		return state;
	}
	
}

class OrderQueue extends LinkedBlockingDeque<Order>{
	
}

class User  implements Runnable{
	private OrderQueue orderQueue;
	private Random random = new Random(100);
	private int id = 0;
	public User(OrderQueue mq) {
		// TODO Auto-generated constructor stub
		orderQueue = mq;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				//Thread.sleep(System.currentTimeMillis() + )
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(1000));
				Order order = new Order(id++,random.nextInt(20)*1000);
				orderQueue.put(order);
			}
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Waitor is interrupted, the Thread is terminating...");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}


class Wang implements Runnable{
	//
	//...一些信息变量
	//
	private int totalMoney = 2000000;
	private Map<Integer, Integer> userOrder = new HashMap<Integer, Integer>();
	private OrderQueue orderQueue;
	private Random random = new Random(100);
	private int id = 0;
	public Wang(OrderQueue eq) {
		// TODO Auto-generated constructor stub
		orderQueue = eq;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				//Thread.sleep(System.currentTimeMillis() + )
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(1000));
				Order order = orderQueue.take();
				if (order.getId() != id++ && order.getState()!=Order.State.CHECKED) {
					System.out.println("The order is wrong!");
				}
				else{
					//do check
					if (totalMoney > order.getMoney()) {
						totalMoney-=order.getMoney();
						userOrder.put(order.getId(), order.getMoney());
;					}
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(100));
				}
			}
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Order is interrupted, the Thread is terminating...");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
public class alitest {
	public static void main(String[] args) {
	 	OrderQueue orderQueue = new OrderQueue();
	   ExecutorService esExecutorService = Executors.newCachedThreadPool();
	 	esExecutorService.execute(new User(orderQueue));
	 	esExecutorService.execute(new Wang(orderQueue));
		try {
			TimeUnit.MILLISECONDS.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		esExecutorService.shutdownNow();
		
	}
}
