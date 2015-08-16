package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.GetConnection;
import dao.Dao;

public class DaoImp implements Dao{

	public String selectFirstName(String firstName) {
		String sql = "select * from customer where first_name = ?";
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setString(1, firstName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(3);
			}return null;
			
		} catch (SQLException e) {
			System.out.println("DaoImp  select    =========  error");
			e.printStackTrace();
			return null ;
		}
	}

	public ResultSet showFilmAllInfo() {
		String sql = "select * from film_text as a left join film as b on a.film_id=b.film_id left join `language` as c on b.language_id=c.language_id";
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("DaoImp  show    =========  error");
			e.printStackTrace();
			return null ;
		}
	}

	public void deleteFilm(int film_id) {
		try {
			String sql ="delete from film_text where film_id ="+film_id;
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.execute(sql);
		} catch (SQLException e) {
			System.out.println("DaoImp  delete    =========  error");
			e.printStackTrace();
		}
	}

	public void insertFilm(int film_id,String title, String description) {
		System.out.println("======="+film_id+title+description);
		try {
			String sql = "insert into film_text values("+film_id+",'"+title+"','"+description+"')";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}
