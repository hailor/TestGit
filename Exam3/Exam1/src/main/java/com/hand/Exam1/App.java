package com.hand.Exam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hand.Exam1.entity.City;
import com.hand.Exam1.entity.Country;
import com.hand.Exam1.utils.ConnectionFactory;

public class App {
    public static void main( String[] args ){
        Connection conn = ConnectionFactory.getInstance().makeConnection();
        System.out.print("输入：\n请输入CountryID：");
        Scanner sc = new Scanner(System.in);
        int country_id = Integer.parseInt(sc.nextLine());
        sc.close();
        Country country;
        String sql1 = "SELECT country FROM country WHERE country_id=?";
        try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			
			ps.setInt(1, country_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				country = new Country();
				country.setCountry(rs.getString(1));
			}
			System.out.println("输出：\nCountry Spain 的城市->");
			System.out.println("城市ID\t|城市名称");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        String sql2 = "SELECT city_id,city FROM city WHERE country_id=?";
        List<City> list = new ArrayList<City>();
        City city;
        try {
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setInt(1, country_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				city = new City();
				city.setCity_id(rs.getInt(1));
				city.setCity(rs.getString(2));
				list.add(city);
			}
			for(City c : list){
				System.out.println(c.getCity_id()+"\t|"+c.getCity());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}