package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDao;
import dao.impl.FilmDaoImpl;
import entity.Film;

public class FilmUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Film film = new Film();
		film.setFilm_id(Integer.parseInt(request.getParameter("film_id")));
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));
		film.setLanguage_id(Integer.parseInt(request.getParameter("language_id")));
		
		FilmDao filmDao = new FilmDaoImpl();
		String msg = "";
		try {
			if(filmDao.update(film)){
				msg = "更新电影成功！";
			}else{
				msg = "更新电影失败！";
			}
			PrintWriter out = response.getWriter();
			out.println("<script>alter("+msg+");window.location='FilmShow';</script>");
			//response.sendRedirect("FilmShow");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}