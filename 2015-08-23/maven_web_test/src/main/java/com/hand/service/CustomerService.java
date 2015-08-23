package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hand.Bean.Customer;
import com.hand.Bean.Film;
import com.hand.DaoImpl.CustomerDaoImpl;
import com.hand.DaoImpl.UserDaoImpl;
import com.hand.dao.CustomerDao;

import com.hand.util.ConnectionFactory;

public class CustomerService {
	private CustomerDao cusdao = new CustomerDaoImpl();
	Connection conn = null;
	
	//获取用户列表
	public ArrayList<Customer> getCustomerList(){
		ArrayList<Customer> customerlist = new ArrayList<Customer>();
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet rs =  cusdao.getcustomerlist(conn);
			while(rs.next()){
				Customer cus = new Customer();
				cus.setCustomer_id(rs.getInt("customer_id"));
				cus.setFirst_Name(rs.getString("first_name"));
				cus.setLast_Name(rs.getString("last_name"));
				cus.setAddress(rs.getString("address"));
				cus.setEmail(rs.getString("email"));
				cus.setLastUpdate(rs.getDate("last_update"));
				customerlist.add(cus);
			}

		} catch (SQLException e) {
			e.printStackTrace ();
			try {
				conn.rollback ();
			} catch (SQLException e1) {
				e1.printStackTrace ();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace ();
			}
		}
		
		
		return customerlist;
		
	}
	//获取用户表总数，显示分页的页数
	public String getCustomerCount(){
		String customercount = null;
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet rs =  cusdao.getcustomercount(conn);
			while(rs.next()){
				customercount=rs.getString("count(customer_id)");
			}

		} catch (SQLException e) {
			e.printStackTrace ();
			try {
				conn.rollback ();
			} catch (SQLException e1) {
				e1.printStackTrace ();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace ();
			}
		}
		
		
		return customercount;
		
	}
	
	public boolean check(Customer cus){
		
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet resultSet = cusdao.get(conn,cus);
			while ( resultSet.next ()) {
				return true ;
			}
		} catch (SQLException e) {
			e.printStackTrace ();
			try {
				conn.rollback ();
			} catch (SQLException e1) {
				e1.printStackTrace ();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace ();
			}
		}
		
	
		return false;
		
	}
}
