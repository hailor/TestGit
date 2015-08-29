package com.hand.handtest;

import org.springframework.context.ApplicationListener;

public class BeforeInsertEventHandler implements ApplicationListener<BeforeInsertFilmEvent>{

	public void onApplicationEvent(BeforeInsertFilmEvent arg0) {
		System.out.println(arg0.toString());
	}

}
