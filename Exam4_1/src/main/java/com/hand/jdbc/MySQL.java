package com.hand.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySQL {
	public MySQL() {
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
	
	/**
	 * 根据ID查film
	 * @param sql
	 * @return
	 */
	public Map filmIdSelect(String filmId){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select f.film_id,f.title,f.description,lan.name from film f join language lan on f.language_id = lan.language_id where f.film_id = "+filmId;
		Map<String , Object> map = new HashMap<String, Object>();
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				map.put("film_id", rs.getInt("film_id"));
				map.put("title", rs.getString("title"));
				map.put("description", rs.getString("description"));
				map.put("language", rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return map;
	}
	
	public ArrayList<String> getAllLanguage(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select name from language";
		ArrayList<String> list = new ArrayList<String>();
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return list;
	}
	
	public int getLanguageId(String LanguageName){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select language_id from language where name = '"+LanguageName+"'";
		int id = -1;
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("language_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return id;
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
