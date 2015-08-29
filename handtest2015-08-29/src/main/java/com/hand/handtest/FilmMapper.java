package com.hand.handtest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hand.Entity.Film;

public class FilmMapper implements RowMapper<Film>{

	public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
		Film film = new Film(); 
		
		film.setTitle(rs.getString("title"));
		film.setDescription(rs.getString("description"));
		film.setLanguage_id(rs.getInt("language_id"));
		return film;
	}

}
