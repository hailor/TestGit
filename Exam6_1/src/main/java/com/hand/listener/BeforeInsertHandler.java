package com.hand.listener;

import org.springframework.context.ApplicationListener;

public class BeforeInsertHandler implements ApplicationListener<BeforeInsertFilmEvent>{

	public void onApplicationEvent(BeforeInsertFilmEvent event) {
		System.out.println(event.toString());
		
	}

}
