package com.hand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			System.out.println("输入：");
			System.out.print("请输入Country ID:");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();

			String sql = "Select country.country,city.city_id,city.city from country,city where country.country_id=city.country_id and country.country_id="
					+ input;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			boolean isFirst = true;
			while (rs.next()) {
				if (isFirst) {
					System.out.println("输出：");
					System.out.println("Countrey"+rs.getString("country")+"的城市>>");
					System.out.println("\t城市ID\t|\t城市名称");
					isFirst = false;
				}
				System.out.println("\t"+rs.getString("city_id") + "\t|\t" + rs.getString("city"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
