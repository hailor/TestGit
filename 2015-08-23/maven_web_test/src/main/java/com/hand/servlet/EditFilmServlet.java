package com.hand.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Film;
import com.hand.Bean.Language;
import com.hand.service.CheckUserLogin;

public class EditFilmServlet extends HttpServlet {
	private CheckUserLogin cku = new CheckUserLogin();
	/**
	 * 
	 */
	private static final long serialVersionUID = 4757465828373058762L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String film_id = req.getParameter("film_id");
		RequestDispatcher rd = null;
		Film fi = cku.getFile(Long.valueOf(film_id));
		System.out.println(film_id);
		ArrayList<Language> langlist = cku.getLanguage();
		req.setAttribute("langlist", langlist);
		req.setAttribute("editfilm", fi);
		rd = req.getRequestDispatcher("/foreditfilm.jsp");
		rd.forward(req, resp);
	}

}
