package com.hand.Exam1;

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

			System.out.println("请输入Country ID：");
			Scanner scanner = new Scanner(System.in);
			int countryId = scanner.nextInt();
			String temp = "select country from country where country_id=" + countryId;
			String sql = "select city_id,city from city,country where city.country_id=country.country_id and country.country_id="
					+ countryId;

			resultSet = statement.executeQuery(temp);
			while (resultSet.next()) {
				String country = resultSet.getString("country");
				System.out.println("Country " + country + "的城市->");
				resultSet = statement.executeQuery(sql);
				System.out.println("城市ID | 城市名称");
				while (resultSet.next()) {
					System.out.println(resultSet.getString("city_id") + " | " + resultSet.getString("city"));
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
