package com.hand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		System.out.println("输入：");
		System.out.print("请输入Customer ID:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT film.film_id,film.title,rental.rental_date,customer.first_name,customer.last_name FROM film INNER JOIN inventory ON inventory.film_id = film.film_id INNER JOIN rental ON rental.inventory_id = inventory.inventory_id INNER JOIN payment ON payment.rental_id = rental.rental_id INNER JOIN customer ON rental.customer_id = customer.customer_id AND payment.customer_id = customer.customer_id AND customer.customer_id = "
					+ input + " ORDER BY rental.rental_date";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			boolean isFirst = true;
			while (rs.next()) {
				if (isFirst) {
					System.out.println("输出：");
					System.out.println(rs.getString("first_name") + "." + rs.getString("last_name") + "租用的Film>>");
					System.out.println("\tFilm ID\t|\tFilm 名称\t|\t租用时间");
					isFirst = false;
				}
				System.out.println("\t" + rs.getString("film_id") + "\t|\t" + rs.getString("title") + "\t|\t"
						+ rs.getString("rental_date"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
