package com.kami.java;
import java.net.CookieHandler;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;


class Meal{
	public enum MealState{
		ORDER,COOKING,EATTING
	}
	private final int mealId;
	private MealState state = MealState.ORDER; 
	public Meal(int id) {
		// TODO Auto-generated constructor stub
		mealId = id;
	}
	public void cook(){
		state = MealState.COOKING;
	}
	public void eat(){
		state = MealState.EATTING;
	}
	public int getId(){
		return mealId;
	}
	public MealState getState(){
		return state;
	}
	public String toString(){
		return "MealID:" + mealId + " is " + state;
	}
}

class MealQueue extends LinkedBlockingDeque<Meal>{
	
}

class Waitor  implements Runnable{
	private MealQueue mealQueue;
	private Random random = new Random(100);
	private int id = 0;
	public Waitor(MealQueue mq) {
		// TODO Auto-generated constructor stub
		mealQueue = mq;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				//Thread.sleep(System.currentTimeMillis() + )
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(1000));
				Meal meal = new Meal(id++);
				System.out.println(meal);
				mealQueue.put(meal);
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

class Cooker implements Runnable{
	private MealQueue mealQueue,cookQueue;
	private Random random = new Random(100);
	public Cooker(MealQueue mq, MealQueue cookqueue) {
		// TODO Auto-generated constructor stub
		mealQueue = mq;
		this.cookQueue = cookqueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				//Thread.sleep(System.currentTimeMillis() + )
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(1000));
				Meal meal = mealQueue.take();
				meal.cook();
				System.out.println(meal);
				cookQueue.put(meal);
			}
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Cooker is interrupted, the Thread is terminating...");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}

class Eator implements Runnable{
	private MealQueue eatQueue;
	private Random random = new Random(100);
	private int id = 0;
	public Eator(MealQueue eq) {
		// TODO Auto-generated constructor stub
		eatQueue = eq;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				//Thread.sleep(System.currentTimeMillis() + )
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(1000));
				Meal meal = eatQueue.take();
				if (meal.getId() != id++ && meal.getState()!=Meal.MealState.EATTING) {
					System.out.println("The meal is bad. Eu.... call your mamanger!");
				}
				else{
				meal.eat();
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(100));
				System.out.println(meal);
				}
			}
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Eator is interrupted, the Thread is terminating...");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
public class ConsumorAndProductor {
	public static void main(String[] args) {
	 	MealQueue preMeal = new MealQueue(),
		cookingMeal = new MealQueue();
	 	
	 	ExecutorService esExecutorService = Executors.newCachedThreadPool();
	 	esExecutorService.execute(new Waitor(preMeal));
	 	esExecutorService.execute(new Cooker(preMeal, cookingMeal));
	 	esExecutorService.execute(new Eator(cookingMeal));
		try {
			TimeUnit.MILLISECONDS.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		esExecutorService.shutdownNow();
		
	}
}
