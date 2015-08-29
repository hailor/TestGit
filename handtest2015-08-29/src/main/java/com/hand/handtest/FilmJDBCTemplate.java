package com.hand.handtest;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.hand.Entity.Film;
import com.hand.dao.FilmDAO;

public class FilmJDBCTemplate implements FilmDAO{
	 private DataSource dataSource;
	 private SimpleJdbcCall jdbcCall;
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcCall =  new SimpleJdbcCall(ds).withProcedureName("getRecord");
	}

	public void create(String title, String description, Integer language_id) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		 String SQL = "insert into film (title, description, language_id) values (?,?,?)";
		 jdbcTemplateObject.update( SQL, title, description,language_id);
		 System.out.println("添加一条记录 title = " + title + " description = " + description +"language_id="+language_id );
	}

//	public Film getStudent(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Film> listStudents() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
