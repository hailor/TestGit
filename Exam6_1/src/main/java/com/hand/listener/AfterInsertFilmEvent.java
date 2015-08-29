package com.hand.listener;

import org.springframework.context.ApplicationEvent;

public class AfterInsertFilmEvent extends ApplicationEvent{

	public AfterInsertFilmEvent(Object source) {
		super(source);
	}
	
	public String toString(){
	      return "After Insert Film Data";
	   }

}
