package com.hand.Exam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("===========程序開始===========");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
			// connection.setAutoCommit(false);

			statement = connection.createStatement();

			System.out.println("请输入Customer ID：");
			Scanner scanner = new Scanner(System.in);
			int customerId = scanner.nextInt();
			String temp = "SELECT first_name,last_name FROM customer WHERE customer_id=" + customerId;
			String sql = "SELECT film.film_id,film.title,rental.rental_date FROM rental,film,inventory WHERE rental.customer_id="+customerId+" AND rental.inventory_id=inventory.inventory_id AND inventory.film_id=film.film_id ORDER BY rental.rental_date DESC";

			resultSet = statement.executeQuery(temp);
			while (resultSet.next()) {
				String name = resultSet.getString("first_name")+"."+resultSet.getString("last_name");
				System.out.println(name + "租用的Film->");
				resultSet = statement.executeQuery(sql);
				System.out.println("Film ID  |  Film 名称   |  租用时间");
				while (resultSet.next()) {
					System.out.println(resultSet.getString("film_id") + "  |  " + resultSet.getString("title") + "  |  " + resultSet.getString("rental_date"));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
				System.out.println("================程序结束=============");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
