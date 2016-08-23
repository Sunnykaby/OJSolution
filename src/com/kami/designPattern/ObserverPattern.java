package com.kami.designPattern;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RadioStation implements Subject{
	List<Observable> observables;
	public RadioStation() {
		// TODO Auto-generated constructor stub
		observables = new LinkedList<Observable>();
	}
	@Override
	public void register(Observable observable) {
		// TODO Auto-generated method stub
		System.out.println("Add a new observer " + observables.size() + " " +observable);
		observables.add(observable);
	}

	@Override
	public void unRegister(Observable observable) {
		// TODO Auto-generated method stub
		observables.remove(observable);
		System.out.println("Remove a observer " +observables.size() + " "+ observable);
	}

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		for (Iterator<Observable> iterator = observables.iterator(); iterator.hasNext();) {
			Observable observable = iterator.next();
			observable.update(message);
		}
	}
	
}

class Radio implements Observable{
	
	private Subject subject;
	
	public Radio(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
	}
	@Override
	public void register() {
		// TODO Auto-generated method stub
		 subject.register(this);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		subject.unRegister(this);
		
	}

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}
	
}

public class ObserverPattern {
	public static void main(String[] args){
		RadioStation radioStation = new RadioStation();
		Radio aRadio = new Radio(radioStation);
		Radio bRadio = new Radio(radioStation);
		
		//register 
		aRadio.register();
		bRadio.register();
		
		//update message
		
		radioStation.update("New radio content is ready~~");
		
		//remove observer
		
		aRadio.remove();
		//bRadio.remove();
		
		radioStation.update("Second content is ready~~");
	}
	
	
}
