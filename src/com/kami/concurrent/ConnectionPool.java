package com.kami.concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
	//first i should have a list to store the connection, so we need a list,because of 
	//frequency insert and release , so we choose LinkedList
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	
	//init func
	
	public ConnectionPool(int size){
		if(size > 0){
			for (int i = 0; i < size; i++) {
				//add connection into the list
				// using the dynamic proxy instead of real ConnectionDriver
				pool.add(ConnectionDriver.createConnection());
			}
		}
	}
	
	// release the connection
	public boolean releaseConnection(Connection connection){
		if (connection!=null) {
			synchronized (pool) {
				pool.add(connection);
				//need to notify others which need a connection that there is a new one
				pool.notify();//should in a syn
			}
			return true;
		}
		return false;
	}
	
	//get a connection, have a timeover func
	public Connection fetchConnection(long time) throws InterruptedException{
		//need to syn
		synchronized (pool) {
			//<=0 means no timeover 
			if (time <= 0) {
			
			while(pool.isEmpty()){
					pool.wait();
			}
				return pool.removeFirst();
			}
			else {
				long future = System.currentTimeMillis() + time;
				long remains = time;
				while(pool.isEmpty() && remains > 0){
					pool.wait();
					remains = future - System.currentTimeMillis();
				}
				Connection result  = null;
				//if time is over connection is null
				if (!pool.isEmpty()) {
					result = pool.removeFirst();
				}
				return result;
				
			}
			
		}
		
	}
	
}
//connection is only a interface, the detail implemented by each DataBase Providers, such as MySQL's 
//conenctionDrivers

//dynamic proxy
class ConnectionDriver implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		if (method.getName().equals("commit")) {
			TimeUnit.MILLISECONDS.sleep(1000);
		}
		return null;
	}
	
	public static final Connection createConnection(){
		//use connectionDriver to Proxy the connection class
		return (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
				new Class<?>[] {Connection.class}, new ConnectionDriver());
	}
	
}
