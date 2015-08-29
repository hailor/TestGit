package com.hand.listener;

import org.springframework.context.ApplicationListener;

public class AfterInsertHandler implements ApplicationListener<AfterInsertFilmEvent> {

	public void onApplicationEvent(AfterInsertFilmEvent event) {
		System.out.println(event.toString());
	}

}
