package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Film;
import com.hand.Bean.Language;
import com.hand.service.CheckUserLogin;

public class AddFileServlet extends HttpServlet {
	private CheckUserLogin cku = new CheckUserLogin();
	/**
	 * 
	 */
	private static final long serialVersionUID = -552976237207773360L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filmtitle = req.getParameter ("title");
		String filmdescription = req.getParameter("description");
		String filmlanguage =req.getParameter("language");
		System.out.println("title:"+filmtitle+",description:"+filmdescription+",language:"+filmlanguage);
		RequestDispatcher rd = null;
		Language lang = cku.getlangid(filmlanguage);
		System.out.println("语言id:"+lang.getLanguage_id());
		//Film file = new Film();
//		file.setTitle(filmtitle);
//		file.setDescription(filmdescription);
//		file.setLanguage(filmlanguage);
		boolean bool = cku.addfilm(filmtitle,filmdescription,lang.getLanguage_id());
		if(bool){
			req.setAttribute("addresult", "插入成功");
		}
		else{
			req.setAttribute("addresult", "插入失败");
		}
		 rd = req.getRequestDispatcher("/addresult.jsp");
		 rd.forward(req, resp);
	}

}
