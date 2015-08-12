package com.hand.Exam1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

import com.mysql.jdbc.UpdatableResultSet;

public class MysqlConnectionCountry {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
			
		    System.out.println("请输入Country ID:");
		    Scanner scan = new Scanner(System.in);
		    int country_id = scan.nextInt();
		    String country_name;
		    String get_country = "select * from country where country_id="+country_id;
		    String sql = "select * from city where city.country_id="+country_id;
		    
		    Statement st = null;
		    ResultSet rs = null;
		    Connection conn = getConnection();
		    try {
		    	st = conn.createStatement();
		    	rs = st.executeQuery(get_country);
		    	rs.next();
		    	country_name=rs.getString(2);
		    	System.out.println("Country "+country_name+"的城市->");
		    	System.out.println("城市 ID|城市名称");
		    	
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					System.out.println(rs.getInt(1)+"    |"+rs.getString(2));
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
