package com.hand.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.jdbc.MySQL;

/**
 * Servlet implementation class FilmMainServlet
 */
public class FilmMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("film", getFilm());
		RequestDispatcher rd = request.getRequestDispatcher("film.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private ArrayList getFilm(){
		ArrayList<Map> list = new ArrayList<Map>();
		
		MySQL mysql = new MySQL();
		String sql = " select f.film_id,f.title,f.description,lan.name from film f join language lan on f.language_id = lan.language_id";
		try {
			ResultSet rs = mysql.select(sql);
			Map<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String, Object>();
				map.put("film_id", rs.getInt("film_id"));
				map.put("title", rs.getString("title"));
				map.put("description", rs.getString("description"));
				map.put("language", rs.getString("name"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
