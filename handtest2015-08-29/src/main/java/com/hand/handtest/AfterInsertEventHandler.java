package com.hand.handtest;

import org.springframework.context.ApplicationListener;

public class AfterInsertEventHandler implements ApplicationListener<AfterInsertFilmEvent>{

	public void onApplicationEvent(AfterInsertFilmEvent arg0) {
		System.out.println(arg0.toString());
	}

}
