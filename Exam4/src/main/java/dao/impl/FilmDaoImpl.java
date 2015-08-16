package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.FilmDao;
import entity.Film;
import utils.ConnectionFactory;

public class FilmDaoImpl implements FilmDao {

	public List<Film> getPageResult() throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "SELECT film_id,title,description,name FROM language,film WHERE film.language_id=language.language_id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Film> list = new ArrayList<Film>();
		Film film = null;
		while(rs.next()){
			film = new Film();
			film.setFilm_id(rs.getInt(1));
			film.setTitle(rs.getString(2));
			film.setDescription(rs.getString(3));
			film.setName(rs.getString(4));
			list.add(film);
		}
		return list;
	}

	public Film queryById(int id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "SELECT film_id,title,description,name FROM language,film WHERE film.language_id=language.language_id AND film_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Film film = null;
		while(rs.next()){
			film = new Film();
			film.setFilm_id(rs.getInt(1));
			film.setTitle(rs.getString(2));
			film.setDescription(rs.getString(3));
			film.setName(rs.getString(4));
		}
		return film;
	}

	public boolean save(Film film) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "INSERT INTO film(title,description,language_id,last_update) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getLanguage_id());
		ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		boolean flag = false;
		if(ps.executeUpdate() != 0){
			flag = true;
		}
		return flag;
	}

	public boolean delete(int id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "DELETE FROM film WHERE film_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		boolean flag = false;
		if(ps.executeUpdate() != 0){
			flag = true;
		}
		return flag;
	}

	public boolean update(Film film) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "UPDATE film SET title=?,description=?,language_id=?,film_id=? WHERE film_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getLanguage_id());
		ps.setInt(4, film.getFilm_id());
		ps.setInt(5, film.getFilm_id());
		boolean flag = false;
		if(ps.executeUpdate() != 0){
			flag = true;
		}
		return flag;
	}
}