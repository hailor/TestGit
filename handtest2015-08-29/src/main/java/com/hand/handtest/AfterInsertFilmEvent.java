package com.hand.handtest;

import org.springframework.context.ApplicationEvent;

public class AfterInsertFilmEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3615773041611727043L;

	public AfterInsertFilmEvent(Object source) {
		super(source);
	}
	public String toString(){
		return "After Insert Film Data";
	}
}
