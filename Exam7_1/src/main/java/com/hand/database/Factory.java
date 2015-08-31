package com.hand.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hand.Exam7_1.MyInterceptor;

public class Factory {

	public static Session getSession(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(new MyInterceptor());
		return session;
	}
}
