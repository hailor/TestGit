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
    	System.out.println("输入：");
    	System.out.print("请输入CountryID：");
    	Scanner scan = new Scanner(System.in);
		int countryid = scan.nextInt();
		System.out.println("输出：");
		
		
    	String sql="SELECT DISTINCT city.city_id,city.city FROM city,country where city.country_id="+countryid;
    	String sql1="select country from country where country_id="+countryid;
    	Connection conn=null;//当前数据库连接
    	Statement st=null;//用于向数据库发送数据
    	ResultSet rs=null;//结果集，封装了从数据库查询到的数据 
    	ResultSet rs1=null;
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");//获取数据库连接
    		st=conn.createStatement();
    		rs1=st.executeQuery(sql1);
    		while(rs1.next()){
    			System.out.println("Country "+rs1.getString("country")+"的城市->");
    		}
    		System.out.println("城市ID|城市名称");
    		rs1.close();
    		rs=st.executeQuery(sql);
    		
    		while(rs.next()){
    			System.out.print(rs.getInt("city_id")+"|");
    			System.out.print(rs.getString("city"));
    			System.out.println();
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e3) {
			}
			try {
				conn.close();
			} catch (Exception e4) {
			}
		}

    }
}
