package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hand.Bean.Film;
import com.hand.Bean.Language;
import com.hand.Bean.User;
import com.hand.DaoImpl.UserDaoImpl;
import com.hand.dao.UserDao;
import com.hand.util.ConnectionFactory;

public class CheckUserLogin {
	private UserDao userDao = new UserDaoImpl() ;
	Connection conn = null;

	public boolean check( User user ) {


		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet resultSet = userDao.get (conn, user) ;
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
		return false ;
	}
	//获取电影列表
	public  ArrayList<Film> getfilmlist(){
		ArrayList<Film> filmlist = new ArrayList<Film>();
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet rs =  userDao.getfilmlist(conn);

			while(rs.next()){
				Film film = new Film();
				
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguage(rs.getString("name"));
				filmlist.add(film);
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

		return filmlist;

	}

	//获取语言表
	public ArrayList<Language> getLanguage(){
		ArrayList<Language> languagelist = new ArrayList<Language>();
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet rs =  userDao.getLanguage(conn);

			while(rs.next()){
				Language lang = new Language();
				lang.setLanguage_id(rs.getLong("language_id"));
				lang.setName(rs.getString("name"));
				languagelist.add(lang);
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
		return languagelist;

	}

	//根据传入的参数，查找语言表的id
	public Language getlangid(String lang){
		Language language = new Language();
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet rs =  userDao.getlangid(conn, lang);
			while(rs.next()){
				language.setLanguage_id(rs.getLong("language_id"));
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
		
		return language;

	}
	
	//向电影表插入一条数据
	public boolean addfilm(String filmtitle, String filmdescription, Long filmlanguage_id){
		boolean bool = false;
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			bool = userDao.addfilm(conn, filmtitle,filmdescription,filmlanguage_id);
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
		
		return bool;
	}
	
	//根据File删除
	public boolean delfilm(Film film){
		boolean bool=false;
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			bool = userDao.deletefilm(conn, film);
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
		
		return bool;
		
	}
	//根据film_id查询到一条特定的电影信息
	public Film getFile(Long film_id){
		ArrayList<Film> filmlist = new ArrayList<Film>();
		Film film = new Film();
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false) ;
			ResultSet rs =  userDao.getfilmlist(conn);

			while(rs.next()){
				if(rs.getLong("film_id")==film_id){
					film.setFilm_id(rs.getInt("film_id"));
					film.setTitle(rs.getString("title"));
					film.setDescription(rs.getString("description"));
					film.setLanguage(rs.getString("name"));
					film.setLanguage_id(rs.getInt("language_id"));
				}
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

		return film;

	}
	//根据Film对象修改信息
	public String editfilm(Film film){
		boolean bool = false;
		String result = null;
		try {
			conn = ConnectionFactory.getInstance ().makeConnection ();
			conn.setAutoCommit (false);
			bool=userDao.editfilm(conn, film);
			if(bool){result = "修改完成";}
			else{result="修改失败";}
			
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
		return result;
	}
	
	
}
