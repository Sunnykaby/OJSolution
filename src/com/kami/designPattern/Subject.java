package com.kami.designPattern;

/**
 * 主题接口，任何实际的主题（内容生产者）都需要实现这个接口
 * @author User
 *
 */
public interface Subject {
	/**
	 *  注册观察者，一个主题可以同时注册多个观察者
	 * @param observable
	 */
	public void register(Observable observable);
	/**
	 * 将该观察者消除
	 * @param observable
	 */
	public void unRegister(Observable observable);
	/**
	 * 向注册的观察者推送消息
	 * @param message
	 */
	public void update(String message);
}
