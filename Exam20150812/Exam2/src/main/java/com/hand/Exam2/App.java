package com.hand.Exam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{

	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}


	public static void printCustomer(int customerID){
		String sql = "SELECT * FROM customer WHERE customer_id="+customerID;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()){
				System.out.println(rs.getString("first_name") + "."+ rs.getString("last_name") + " 租用的Film->");
			}

		} catch (Exception e) {
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e2) {
			}
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}

	public static void printFilm(int customerID){
		String sql = "SELECT * FROM rental WHERE customer_id="+customerID;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int filmID;
		String filmName,time;
		
		System.out.println("Film ID"+"\t|"+"Film 名称"+"\t\t|"+"租用时间");

		try {

			conn = getConnection();

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()){

				time = rs.getString("rental_date");
				int inventory_id = rs.getInt("inventory_id");

				filmID = printFilmID(inventory_id);				

				filmName = printFilmName(filmID);
				System.out.println(filmID+"\t|"+filmName+"\t\t|"+time);



			}

		} catch (Exception e) {
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e2) {
			}
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}

	public static String printFilmName(int filmID){
		String sql = "SELECT * FROM film WHERE film_id="+filmID;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String filmName = "";

		try {

			conn = getConnection();

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()){
				filmName = rs.getString("title");
			}

		} catch (Exception e) {
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e2) {
			}
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
		return filmName;
	}


	public static int printFilmID(int inventoryID){
		String sql = "SELECT * FROM inventory WHERE inventory_id="+inventoryID;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int filmID = 0;

		try {

			conn = getConnection();

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()){
				filmID = rs.getInt("film_id");
			}

		} catch (Exception e) {
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e2) {
			}
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
		return filmID;
	}


	public static void main( String[] args )
	{
		int customerID;

		System.out.print("请输入Customer ID:");

		Scanner in = new Scanner(System.in);
		customerID = in.nextInt();
		printCustomer(customerID);
		printFilm(customerID);

	}
}