package com.hand.Exam3_2;

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
public class App 
{
	public App(){
		System.out.print( "请输入Customer ID:" );
        Scanner read = new Scanner(System.in);
        String customerID = read.nextLine();
        System.out.println( selectCustomer(customerID)+" 租用的Film‐>");
        System.out.println("Film ID|Film 名称| 租用时间");
		select(customerID);
	}
	
	public Connection getConnection(){
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
	
	public String selectCustomer(String customerId){
		String sql = "select first_name,last_name from customer where customer_id = "+customerId;
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		String name = null;
		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				name = rs.getString("first_name")+"."+rs.getString("last_name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
		return name;
	
	}
	
	public void select(String customerID){
		String sql = "select rental.inventory_id,rental.rental_date from rental where rental.customer_id = "+customerID;
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		Connection conn2 = getConnection();
		Statement st2 = null;
		ResultSet rs2 = null;
		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			String sql2;
			
			while(rs.next()){
//				System.out.print(rs.getInt("inventory_id")+"    ");
				sql2 = "select film.film_id,film.title from film  where film.film_id in (  select inventory.film_id from inventory where inventory.inventory_id = "+rs.getInt("inventory_id")+")";
				conn2 = getConnection();
				st2 = conn2.createStatement();
				rs2 = st2.executeQuery(sql2);
				while(rs2.next()){
					System.out.print(rs2.getInt("film_id")+"    ");
					System.out.print("| "+rs2.getString("title")+"  ");
				}
				
				System.out.print("| "+rs.getDate("rental_date")+"  ");
//				System.out.print("| "+rs.getString("rental_date")+"  ");
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				rs2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
				st2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
				conn2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
    public static void main( String[] args )
    {
        new App();
    }
}
