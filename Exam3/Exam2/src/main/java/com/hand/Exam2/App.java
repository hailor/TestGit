package com.hand.Exam2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hand.Exam2.entity.Customer;
import com.hand.Exam2.entity.Film;
import com.hand.Exam2.utils.ConnectionFactory;

public class App {
    public static void main( String[] args ){
        System.out.print("输入：\n请输入CustomerID：");
        Scanner sc = new Scanner(System.in);
        int customer_id = Integer.parseInt(sc.nextLine());
        sc.close();
        
        Connection conn = ConnectionFactory.getInstance().makeConnection();
        String sql1 = "SELECT first_name,last_name FROM customer WHERE customer_id=?";
        Customer customer = null;
        try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				customer = new Customer();
				customer.setFirst_name(rs.getString(1));
				customer.setLast_name(rs.getString(2));
			}
        } catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println("输出：");
        System.out.println(customer.getFirst_name()+"."+customer.getLast_name()+" 租用的Film->");
        System.out.println("Film ID\t|Film 名称| 租用时间");
        String sql2 = "SELECT film_id,title FROM film WHERE film_id IN ("
        		+ "SELECT film_id FROM inventory WHERE inventory_id IN ("
        		+ "SELECT inventory_id FROM rental WHERE customer_id=? "
        		+ "))";
        List<Film> list = new ArrayList<Film>();
        Film film;
        try {
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				film = new Film();
				film.setFilm_id(rs.getInt(1));;
				film.setTitle(rs.getString(2));
				list.add(film);
			}
        } catch (SQLException e) {
			e.printStackTrace();
		}
        
        String sql3 = "SELECT rental_date FROM rental WHERE customer_id=? "
        		;
        List<Timestamp> list2 = new ArrayList<Timestamp>();
        try {
			PreparedStatement ps = conn.prepareStatement(sql3);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list2.add(rs.getTimestamp(1));
			}
			int i = 0;
			for(Film f : list){
				System.out.println(f.getFilm_id()+"\t|"+f.getTitle()+"|"+list2.get(i));
				i++;
			}
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }
}