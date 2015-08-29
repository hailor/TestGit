package com.hand.dao;

import java.util.List;
import javax.sql.DataSource;
import com.hand.Entity.Film;

public interface FilmDAO {
	 public void setDataSource(DataSource ds);
	 
	 public void create(String title,String description,Integer language_id);
	 
	 /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
//	 public Film getStudent(Integer id);
//	 public List<Film> listStudents();
}
