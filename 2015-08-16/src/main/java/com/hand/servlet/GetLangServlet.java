package com.hand.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Language;
import com.hand.service.CheckUserLogin;

public class GetLangServlet extends HttpServlet {
	private CheckUserLogin cku = new CheckUserLogin();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1334989484850621707L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ArrayList<Language> langlist = cku.getLanguage();
		req.setAttribute("langlist", langlist);
		rd = req.getRequestDispatcher("/addfilm.jsp");
		 rd.forward(req, resp);
	}

}
