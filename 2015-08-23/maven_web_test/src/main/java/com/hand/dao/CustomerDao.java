package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.hand.Bean.Customer;
import com.hand.Bean.User;

public interface CustomerDao {
	public ResultSet get(Connection conn, Customer cus)throws SQLException;
	//ajax
	//public ResultSet getcustomerlist(Connection conn,int start,int finish)throws SQLException;
	public ResultSet getcustomerlist(Connection conn)throws SQLException;
	public ResultSet getcustomercount(Connection conn)throws SQLException;

	public ResultSet getCustomerListStart(Connection conn,int start)throws SQLException;
	//删除客户主要信息
	public int deleteCustomer(Connection conn,Customer cus)throws SQLException;
	//删除客户信息外键关联表1payment
	public int deleteCusWithPayment(Connection conn,Customer cus)throws SQLException;
	//删除客户信息外键关联标2rental
	public int deleteCusWithRental(Connection conn,Customer cus)throws SQLException;
}
