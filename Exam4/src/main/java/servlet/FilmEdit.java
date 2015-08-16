package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDao;
import dao.impl.FilmDaoImpl;
import entity.Film;
import entity.Language;
import utils.ConnectionFactory;

public class FilmEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int film_id = Integer.parseInt(request.getParameter("film_id"));
		FilmDao filmDao = new FilmDaoImpl();
		try {
			Film film = filmDao.queryById(film_id);
			if(film != null){
				String sql = "SELECT language_id,name FROM language";
				List<Language> list = new ArrayList<Language>();
				Language language;
				try {
					Connection conn = ConnectionFactory.getInstance().makeConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						language = new Language();
						language.setLanguage_id(rs.getInt(1));
						language.setName(rs.getString(2));
						list.add(language);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("film", film);
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("filmEdit.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}