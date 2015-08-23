package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Bean.Film;
import com.hand.Bean.Language;
import com.hand.Bean.User;

public interface UserDao {
	  public ResultSet get(Connection conn, User user)throws SQLException;
	  
	  public ResultSet getfilmlist(Connection conn)throws SQLException;

	  //public boolean addfilm(Connection conn,Film film)throws SQLException;
	  public boolean addfilm(Connection conn,String filmtitle,String filmdescription,Long filmlanguage_id)throws SQLException;
	  
	  public boolean deletefilm(Connection conn,Film film)throws SQLException;
	  
	  public boolean editfilm(Connection conn,Film film)throws SQLException;
	  //获取语言表
	  public ResultSet getLanguage(Connection conn)throws SQLException;
	  
	  public ResultSet getlangid(Connection conn,String lang)throws SQLException;
}
