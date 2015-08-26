package com.hand.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Bean.Customer;
import com.hand.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	public ResultSet getcustomerlist(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT cus.customer_id,cus.first_name,cus.last_name,cus.email,cus.last_update,ad.address FROM customer cus left join address ad on ad.address_id=cus.address_id limit 0,10;");
		return ps.executeQuery();
	}
	public ResultSet getCustomerListStart(Connection conn,int start) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("SELECT cus.customer_id,cus.first_name,cus.last_name,cus.email,cus.last_update,ad.address FROM customer cus left join address ad on ad.address_id=cus.address_id limit ?,?;");
		ps.setInt(1, start);
		ps.setInt(2, 10);
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
	public int deleteCustomer(Connection conn, Customer cus) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete customer from customer where customer_id = ?;");
		ps.setInt(1, cus.getCustomer_id());
		return ps.executeUpdate();
	}
	public int deleteCusWithPayment(Connection conn, Customer cus) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete pay from customer as cus,payment as pay where cus.customer_id = pay.customer_id and cus.customer_id =?;");
		ps.setInt(1, cus.getCustomer_id());
		return ps.executeUpdate();
	}
	public int deleteCusWithRental(Connection conn, Customer cus) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete ren from customer as cus,rental as ren where cus.customer_id = ren.customer_id and cus.customer_id =?;");
		ps.setInt(1, cus.getCustomer_id());
		return ps.executeUpdate();
	}

}
