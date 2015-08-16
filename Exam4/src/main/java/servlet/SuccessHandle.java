package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.DaoImp;

public class SuccessHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DaoImp daoimp = new DaoImp();
       
    public SuccessHandle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int film_id = Integer.parseInt(request.getParameter("a"));
		daoimp.deleteFilm(film_id);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
