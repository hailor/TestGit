package com.hand.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hand.util.ConnectionFactory;

public class ConnectionDateBase {
	
	public static Connection getConnection(){
		Connection conn = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		//1.使用配置文件连接数据库
		ConnectionFactory cf = ConnectionFactory.getInstance();
		conn = cf.makeConnection();
		return conn;
	}
}
