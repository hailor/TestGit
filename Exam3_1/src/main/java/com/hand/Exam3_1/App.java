package com.hand.Exam3_1;

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
		System.out.print( "请输入Country ID:" );
        Scanner read = new Scanner(System.in);
        String countryID = read.nextLine();
        System.out.println( "Country "+selectCountry(countryID)+" 的城市‐>");
        System.out.println("城市ID  |  城市名称");
		select(countryID);
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
	
	public String selectCountry(String countryId){
		String sql = "select country from country where country_id = "+countryId;
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		String country = null;
		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				country = rs.getString("country");
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
		return country;
	
	}
	
	public void select(String countryId){
		String sql = "select city_id,city from city where country_id = "+countryId;
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt("city_id")+"    ");
				System.out.print("| "+rs.getString("city")+"  ");
				System.out.println();
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
	
	}
	
    public static void main( String[] args )
    {
        new App();
    }
}
