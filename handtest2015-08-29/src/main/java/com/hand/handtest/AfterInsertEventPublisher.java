package com.hand.handtest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class AfterInsertEventPublisher implements ApplicationEventPublisherAware{
	private ApplicationEventPublisher publisher;
	public void setApplicationEventPublisher(ApplicationEventPublisher event) {
		this.publisher = event;
	}
	public void publish() {
		BeforeInsertFilmEvent ce = new BeforeInsertFilmEvent(this);
	    publisher.publishEvent(ce);
	}
}
