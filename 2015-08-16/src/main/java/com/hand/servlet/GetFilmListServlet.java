package com.hand.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Film;
import com.hand.service.CheckUserLogin;

public class GetFilmListServlet extends HttpServlet {
	private CheckUserLogin cku = new CheckUserLogin();
	/**
	 * 
	 */
	private static final long serialVersionUID = -1832740370921524437L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RequestDispatcher rd = null;
		 String del = null;
		 ArrayList<Film> filmlist = cku.getfilmlist();
		 del = req.getParameter("del");
		 //String filmlist[] = cku.getfilmlist();
		 //String film = null;
		 //ResultSet filmlist = cku.getfilmlist();
//		 int i = 0;
//		 try {
//			while(filmlist.next()){
//				 req.setAttribute("film"+i, "film_id= "+filmlist.getLong("film_id")+",title="+filmlist.getString("title")+",description= "+filmlist.getString("description")+",film_language="+filmlist.getString("name")+"\n");
//			 }
//			req.setAttribute("num", i);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 int j = 0;
//		 for (j = 0; j < filmlist.size(); j++) {
//			 req.setAttribute("film"+j, filmlist.get(j));
//		 }
		 //req.setAttribute("for_i", j);
		 
		 //System.out.println("数据库访问完成");
		 //System.out.println(film);
		 req.setAttribute("filmlist", filmlist);
		// rd = req.getRequestDispatcher("/filmlist.jsp");
		 System.out.println(del);
		 if(del.equals("getlist")){rd = req.getRequestDispatcher("/filmlist.jsp");}
		 if(del.equals("del")){rd = req.getRequestDispatcher("/deletefilm.jsp");}
		 if(del.equals("edit")){rd = req.getRequestDispatcher("/editfilm.jsp");}
		 rd.forward(req, resp);
	}
	
	
}
