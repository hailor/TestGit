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

public class FilmAdd2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Film film = new Film();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));
		film.setLanguage_id(Integer.parseInt(request.getParameter("language_id")));
		FilmDao filmDao = new FilmDaoImpl();
		try {
			PrintWriter out = response.getWriter();
			boolean flag = filmDao.save(film);
			if(flag){
				out.println("<script>alert('新增电影成功！');</script>");
				out.flush();
				response.sendRedirect("FilmShow");
			}else{
				out.println("<script>alert('新增电影失败，请重新添加！');history.go(-1);</script>");
				out.flush();
			}
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}