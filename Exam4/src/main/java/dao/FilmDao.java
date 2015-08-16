package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Film;

public interface FilmDao {
	
	public List<Film> getPageResult() throws SQLException;
	public Film queryById(int id) throws SQLException;
	public boolean save(Film film) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(Film film) throws SQLException;
}