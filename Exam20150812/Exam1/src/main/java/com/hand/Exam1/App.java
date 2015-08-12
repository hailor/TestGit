package com.hand.Exam1;

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
	

	
	public static void printCountry(int countryID){
		String sql = "SELECT * FROM country WHERE country_id="+countryID;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("Country " + rs.getString("country") + " 的城市->");
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

	
	public static void printCity(int countryID){
		String sql = "SELECT * FROM city WHERE country_id="+countryID;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.println("城市ID" + "\t|" + "城市名称");
			while(rs.next()){
				System.out.println(rs.getString("city_id") + "\t|" + rs.getString("city"));
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
	
	
    public static void main( String[] args )
    {
        int countryID;
        
        System.out.print("请输入Country ID:");
        
        Scanner in = new Scanner(System.in);
        countryID = in.nextInt();
        printCountry(countryID);
        
        printCity(countryID);
        
        
    }
}
