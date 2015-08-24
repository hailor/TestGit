package com.hand.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	private static final ConnectionFactory factory = new ConnectionFactory();

	static {
		try {
			Properties prop = new Properties();
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
			driver = prop.getProperty("driver");
			dburl = prop.getProperty("dburl");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
