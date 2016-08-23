package com.kami.designPattern;

/**
 * 观察者接口
 * @author User
 *
 */
public interface Observable {
	/**
	 * 成为主题对象的观察者
	 * 这里一个观察者只能观察一个主题，其实现中需要有一个成员变量来保存这个主题的引用
	 * 其实就是将这个观察者和主题进行关联，这里将观察者告知主题
	 */
	public void register();
	/**
	 * 不再监听这个主题对象的信息
	 * 
	 */
	public void remove();
	/**
	 * 收到主题对象的更新信息，doSomething，更新信息
	 * @param message
	 */
	public void update(String message);
	
}
