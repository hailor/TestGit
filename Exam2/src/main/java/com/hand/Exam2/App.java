package com.hand.Exam2;

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
    	System.out.print("请输入Customer ID：");
    	Scanner scan = new Scanner(System.in);
		int customerid = scan.nextInt();
		System.out.println("输出：");
		
		
    	String sql="select DISTINCT film.film_id,film.title,rental.rental_date from customer,rental,inventory,film where "
    	+customerid+"=rental.customer_id and rental.inventory_id=inventory.inventory_id and inventory.film_id=film.film_id order by rental.rental_date DESC";
    	String sql1="select first_name,last_name from customer where customer_id="+customerid;
    	Connection conn=null;//当前数据库连接
    	Statement st=null;//用于向数据库发送数据
    	ResultSet rs=null;//结果集，封装了从数据库查询到的数据 
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");//获取数据库连接
    		st=conn.createStatement();
    		rs=st.executeQuery(sql1);
    		while(rs.next()){
    			System.out.print(rs.getString("first_name")+".");
    			System.out.println(rs.getString("last_name")+"租用的film->");
    		}
    		System.out.println("Film ID|Film 名称|租用时间");
    		
    		rs=st.executeQuery(sql);
    		
    		while(rs.next()){
    			System.out.print(rs.getInt("film_id")+"|");
    			System.out.print(rs.getString("title")+"|");
    			System.out.print(rs.getString("rental_date"));
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
