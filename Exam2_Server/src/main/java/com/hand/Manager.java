package com.hand;

import java.util.Vector;

public class Manager {

	private Manager(){}
	private static final Manager cm = new Manager();
	public static Manager getChatManager() {
		return cm;
	}
	
	Vector<_Socket> vector = new Vector<_Socket>();
	
	public void add(_Socket cs) {
		vector.add(cs);
	}
	
	public void remove(_Socket cs) {
		vector.remove(cs);
	}
	
}
