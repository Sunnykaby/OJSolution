package com.kami.java;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface InterfaceFunc{
	void doSomeThing();
	void doSomeThingElse();
}

class Fucking implements InterfaceFunc {
	public void doSomeThing(){
		System.out.println("Fucking is so wonderful.");
	}
	
	public void doSomeThingElse(){
		System.out.println("Do thing without fuck is boring.");
	}
}

class DynamicProxy implements InvocationHandler{
	
	private Object proxiedObject; //一定要用Object，因为不知道具体的类型。这个参数就是需要代理的对象，然后调用这个对象的各种方法。
	public DynamicProxy(Object proxiedObject) {
		// TODO Auto-generated constructor stub
		this.proxiedObject = proxiedObject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Proxy: " + proxy.getClass());//如果把整个类打印的话，会造成stack overFlow
		System.out.println("The method's name is "+method.getName());
		if (args!=null) {
			for(Object currentObject:args){
				System.out.println("Args: " + currentObject);
			}
		}
			
		return method.invoke(proxiedObject, args);
	
	}
	
}

public class ProxyTest {
	
	public static void consum(InterfaceFunc objectFunc){
		objectFunc.doSomeThing();
		objectFunc.doSomeThingElse();
	}
	public static void main(String[] args){
		Fucking hahaFucking = new Fucking();
		consum(hahaFucking);
		InterfaceFunc proxyFunc = (InterfaceFunc)Proxy.newProxyInstance(InterfaceFunc.class.getClassLoader(), new Class[] {InterfaceFunc.class}, new DynamicProxy(hahaFucking));
		consum(proxyFunc);
	}

}
