package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.DaoImp;


public class InsertHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DaoImp daoimp = new DaoImp();

	public InsertHandle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String f = request.getParameter("film_id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		RequestDispatcher rd = null;
		if (f != null && title != null && description != null) {
			int film_id = Integer.parseInt(f);
			daoimp.insertFilm(film_id, title, description);
			rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}else{
			rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
		}


	}

}
