package com.hand.handtest;

import org.springframework.context.ApplicationEvent;

public class BeforeInsertFilmEvent extends ApplicationEvent{

	public BeforeInsertFilmEvent(Object source) {
		super(source);
	}
	public String toString(){
		return "Before Insert Film Data";
	}


}
