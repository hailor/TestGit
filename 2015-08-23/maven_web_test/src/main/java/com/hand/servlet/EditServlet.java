package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Film;
import com.hand.service.CheckUserLogin;

public class EditServlet extends HttpServlet {
	private CheckUserLogin cku = new CheckUserLogin();

	/**
	 * 
	 */
	private static final long serialVersionUID = 3967497979874433345L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String film_id = req.getParameter("film_id");
		String fiml_title = req.getParameter("title");
		String fiml_description = req.getParameter("description");
		String fiml_lang = req.getParameter("language");
		String lang_id = req.getParameter("language_id");
		Film fi = new Film();
		fi.setFilm_id(Integer.valueOf(film_id));
		fi.setTitle(fiml_title);
		fi.setDescription(fiml_description);
		fi.setLanguage(fiml_lang);
		fi.setLanguage_id(Integer.valueOf(lang_id));
		System.out.println(fi.toString());
		String result = cku.editfilm(fi);
		req.setAttribute("editresult", result);
		rd = req.getRequestDispatcher("/editresult.jsp");
		rd.forward(req, resp);
		
	}

}
