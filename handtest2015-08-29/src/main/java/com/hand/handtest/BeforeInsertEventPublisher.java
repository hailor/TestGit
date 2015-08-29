package com.hand.handtest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class BeforeInsertEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher = arg0;
		
	}
	public void publish() {
		BeforeInsertFilmEvent ce = new BeforeInsertFilmEvent(this);
	    publisher.publishEvent(ce);
	}

}
