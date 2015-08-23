package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Bean.Customer;
import com.hand.Bean.User;

public interface CustomerDao {
	public ResultSet get(Connection conn, Customer cus)throws SQLException;
	//ajax
	//public ResultSet getcustomerlist(Connection conn,int start,int finish)throws SQLException;
	public ResultSet getcustomerlist(Connection conn)throws SQLException;
	public ResultSet getcustomercount(Connection conn)throws SQLException;
}
