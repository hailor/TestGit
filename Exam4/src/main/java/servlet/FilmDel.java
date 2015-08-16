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

public class FilmDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int film_id = Integer.parseInt(request.getParameter("film_id"));
		FilmDao filmDao = new FilmDaoImpl();
		try {
			PrintWriter out = response.getWriter();
			if(filmDao.delete(film_id)){
				out.println("<script>alert('删除电影成功！');</script>");
				//out.flush();
				response.sendRedirect("FilmShow");
			}else{
				out.println("<script>alert('删除电影失败！');</script>");
				//out.flush();
				response.sendRedirect("FilmShow");
			}
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}