package com.hand.Exam1;

import java.sql.Connection;

public class ConnectionFactory_test {

	public static void main(String[] args) throws Exception {
		ConnectionFactory cf = ConnectionFactory.getInstance();

		Connection conn = cf.makeConnection();

		System.out.println(conn.getAutoCommit());
	}

}
