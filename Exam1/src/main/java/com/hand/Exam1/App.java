package com.hand.Exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println("请输入country_id");
		Scanner scan =new Scanner(System.in);
		int country_id = scan.nextInt();
		System.out.print("country     ");
		get_country_name(country_id);
		get_city_name(country_id);


	}

	public static void get_city_name(Integer country_id)
	{
		String sql1= "select city_id,city from city where country_id='"+ country_id +"'";  
		String sql2= "select country from country where country_id='"+country_id+"'";
		Connection conn = null;
		Statement st =null;
		ResultSet rs1 =null;
		ResultSet rs2 =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");     
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");

			st=conn.createStatement();
			rs1=st.executeQuery(sql1);
			while(rs1.next())
			{
				System.out.print(rs1.getInt("city_id")+"   ");
				System.out.print("|");
				System.out.print(rs1.getString("city")+"   ");
				System.out.println();

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
		public static void get_country_name(Integer country_id)
		{
			String sql2= "select country from country where country_id='"+country_id+"'";
			Connection conn = null;
			Statement st =null;
			ResultSet rs2 =null;
			try{
				Class.forName("com.mysql.jdbc.Driver");     
				conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");

				st=conn.createStatement();
				rs2=st.executeQuery(sql2);
				while(rs2.next())
				{
					System.out.print(rs2.getString("country")+"的城市 ->");
					System.out.println();
				}


			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
