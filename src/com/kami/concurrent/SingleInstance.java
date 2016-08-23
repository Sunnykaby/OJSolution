package com.kami.concurrent;


public class SingleInstance {
	
	private static SingleInstance instance;
	
	private SingleInstance(){
		
	}
	
	public static final synchronized SingleInstance getInstance() {
		if (instance==null) {
			synchronized (SingleInstance.class) {
				if (instance==null) {
					instance = new SingleInstance();
				}
			}
		}
		return instance;
	}
	
	
	public static void main(String[] args){
		SingleInstance s1 = SingleInstance.getInstance();
		SingleInstance s2 = SingleInstance.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		//how to create a new arrays
		SingleInstance[] listInstances  = new SingleInstance[] {
				SingleInstance.getInstance(),SingleInstance.getInstance()
		};
		System.out.println(listInstances.toString());
		
		Integer[] intl = new Integer[] {
				1,2,3,4,5,6
		};
		for (int i = 0; i < intl.length; i++) {
			System.out.println(intl[i]);
		}
	}
}
