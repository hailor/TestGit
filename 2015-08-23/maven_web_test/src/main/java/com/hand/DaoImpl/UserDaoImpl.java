package com.hand.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Bean.Film;
import com.hand.Bean.Language;
import com.hand.Bean.User;
import com.hand.dao.UserDao;

public class UserDaoImpl implements UserDao {

	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT first_name FROM customer");
		return ps.executeQuery();
	}

	public ResultSet getfilmlist(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select fi.film_id,fi.title,fi.description,lang.name,lang.language_id from film fi left join language lang on lang.language_id=fi.language_id");
		return ps.executeQuery();
	}

//	public boolean addfilm(Connection conn, Film film) throws SQLException {
//		PreparedStatement ps = conn.prepareStatement("INSERT INTO film(title, description, language_id) values (?, ?, ?)");
//		 ps.setString(1, film.getTitle());
//         ps.setString(2, film.getDescription());
//         ps.setLong(3, film.getLanguage_id());
//         Boolean bool = ps.execute();
//         return bool;
//	}

	public boolean deletefilm(Connection conn, Film film) throws SQLException {
		 PreparedStatement ps = conn.prepareStatement("DELETE FROM film where film_id = ?");
		 ps.setLong(1, film.getFilm_id());
		 boolean bool = ps.execute();
		 return bool;
	}

	public boolean editfilm(Connection conn, Film film) throws SQLException {
		String sql = "update film set title =?,description=?,language_id=? where film_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getLanguage_id());
		ps.setInt(4, film.getFilm_id());
		return ps.execute();
	}

	public ResultSet getLanguage(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT language_id,name FROM language");
		return ps.executeQuery();
	}



	public ResultSet getlangid(Connection conn, String lang) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT language_id FROM language where name = ?");
		ps.setString(1, lang);
		return ps.executeQuery();

	}

	public boolean addfilm(Connection conn, String filmtitle, String filmdescription, Long filmlanguage_id)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO film(title, description, language_id) values (?, ?, ?)");
		ps.setString(1, filmtitle);
		ps.setString(2, filmdescription);
		ps.setLong(3, filmlanguage_id);
		Boolean bool = ps.execute();
		return bool;
	}



}
