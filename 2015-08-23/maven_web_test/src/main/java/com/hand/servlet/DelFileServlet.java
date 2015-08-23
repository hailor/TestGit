package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Film;
import com.hand.service.CheckUserLogin;

public class DelFileServlet extends HttpServlet {
	private CheckUserLogin cku = new CheckUserLogin();
	/**
	 * 
	 */
	private static final long serialVersionUID = -1006981661921231438L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String file_id = req.getParameter("film_id");
		
		RequestDispatcher rd = null;
		Film film = new Film();
		
		film.setFilm_id(Integer.valueOf(file_id));
		boolean bool = cku.delfilm(film);
		if(bool){
			req.setAttribute("delresult", "删除成功");
		}
		else{
			req.setAttribute("delresult", "删除失败");
		}
		rd = req.getRequestDispatcher("/delresult.jsp");
		rd.forward(req, resp);
	}

}
