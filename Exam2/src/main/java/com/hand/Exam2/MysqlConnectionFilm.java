package com.hand.Exam2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

import com.mysql.jdbc.UpdatableResultSet;

public class MysqlConnectionFilm {
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

		System.out.println("请输入Customer ID:");
		Scanner scan = new Scanner(System.in);
		int customer_id = scan.nextInt();
		String people_name = null;
		String return_date[] = new String[1000];
		int inventory_id[] = new int[1000];
		int film[] = new int[1000];
		String film_name[] = new String[1000];
		String get_inventory_id = "select * from rental where customer_id="+customer_id+" order by return_date desc";
		String get_film_id = "select * from inventory where inventory_id=";
		String get_film_name = "select * from film where film_id=";

		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;

		Statement st2 = null;
		ResultSet rs2 = null;

		Statement st3 = null;
		ResultSet rs3 = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from customer where customer_id="+customer_id);
			rs.next();
			people_name = rs.getString(3)+" "+rs.getString(4);
			System.out.println(people_name+"租用的 Film->");
			System.out.println("Film ID|Film 名称| 租用时间");
			int i=0,count=0;
			st = conn.createStatement();
	    	rs = st.executeQuery(get_inventory_id);
	    				
			while( rs.next() ){
				return_date[i] = rs.getString(2);
				inventory_id[i] = rs.getInt("inventory_id");
				i++;
			}
			count = i;
			for (int j = 0; j < count; j++) {
				st2 = conn.createStatement();
				rs2 = st.executeQuery(get_film_id+inventory_id[j]);
				rs2.next();
				film[j]=rs2.getInt("film_id");
			}
			for (int j = 0; j < count; j++) {
				st3 = conn.createStatement();
				rs3 = st.executeQuery(get_film_name+film[j]);
				rs3.next();
				film_name[j]=rs3.getString("title");
			}
			
			for (int j = 0; j < count; j++) {
				System.out.println(film[j]+"|  "+film_name[j]+"|  "+return_date[j]);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
