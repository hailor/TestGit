package com.hand.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Bean.Customer;
import com.hand.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	public ResultSet getcustomerlist(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT cus.customer_id,cus.first_name,cus.last_name,cus.email,cus.last_update,ad.address FROM customer cus left join address ad on ad.address_id=cus.address_id;");

		return ps.executeQuery();
		
	}
	public ResultSet getcustomercount(Connection conn)throws SQLException{
		PreparedStatement ps = conn.prepareStatement("select count(customer_id) from customer;");
		return ps.executeQuery();
		
	}
	public ResultSet get(Connection conn, Customer cus) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT customer_id FROM customer where first_name = ? and last_name = ?");
		ps.setString(1, cus.getFirst_Name());
		ps.setString(2, cus.getLast_Name());
		return ps.executeQuery();
	}

}
