package com.hand.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.hand.listener.AfterInsertFilmEvent;
import com.hand.listener.BeforeInsertFilmEvent;

public class MySQL implements ApplicationEventPublisherAware{
	String testMassage;
	private ApplicationEventPublisher publisher;
	   
	public MySQL(String message){
		this.testMassage = message;
	}
	public MySQL(){
		this.testMassage = "没有传递过来的message";
	}
	
	public void test(){
		System.out.println("-------------------"+testMassage+"-------------------");
	}
	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void afterPublish() {
		AfterInsertFilmEvent ae = new AfterInsertFilmEvent(this);
		publisher.publishEvent(ae);
	}
	
	public void beforePublish() {
		BeforeInsertFilmEvent be = new BeforeInsertFilmEvent(this);
		publisher.publishEvent(be);
	}
	
	/**
	 * 查询数据库，返回结果集
	 * @param sql 要执行的查询语句
	 * @return
	 */
	public ResultSet select(String sql){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return rs;
	}
	
	
	
	public boolean update(String sql){
		Connection conn = null;
		Statement st = null;
		boolean rs = true;
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			rs = false;
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
