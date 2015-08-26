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
	public Map<String,Object> filmIdSelect(String customer_id){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select customer_id,first_name,last_name,email,last_update from customer where customer_id = "+customer_id;
		Map<String , Object> map = new HashMap<String, Object>();
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				map.put("customer_id", rs.getInt("customer_id"));
				map.put("first_name", rs.getString("first_name"));
				map.put("last_name", rs.getString("last_name"));
				map.put("email", rs.getString("email"));
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
	
	public ArrayList<String> getAllAddress(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select address from address";
		ArrayList<String> list = new ArrayList<String>();
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString("address"));
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
	
	public int getLanguageId(String address){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select address_id from address where address = '"+address+"'";
		int id = -1;
		try {
			conn = ConnectionDateBase.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("address_id");
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
