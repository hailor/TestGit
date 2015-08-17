package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.User;
import com.hand.service.CheckUserLogin;

public class LoginCheckServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6447580429268429387L;
	private CheckUserLogin cku = new CheckUserLogin();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String uname = req.getParameter ("cname");
		 RequestDispatcher rd = null;
		 String forward = null;
		 //输入为空
		 if(uname == null){
			 //req.setAttribute ("msg", "用户名为空");
			 req.getSession().setAttribute("msg", "error");
			 rd = req.getRequestDispatcher("/login/login.jsp");
			 rd.forward(req, resp);
		 }
		 else
		 {
			 User user = new User ();
			 user.setUsername(uname);
			 boolean bool = cku.check(user);
			 System.out.println("checkuser:"+bool);
			 if(bool){
				 //登录成功 
				 forward = "/index.jsp";
				 req.getSession().setAttribute ("msg", "login");
				 req.getSession().setAttribute("flag", "success");
				 System.out.println("登录成功");
			 }
			 else{
				 //登录失败
				 req.getSession().setAttribute("msg", "error");
				 req.getSession().setAttribute("flag", "error");
				 forward = "/login/login.jsp";
			 }
			 rd = req.getRequestDispatcher (forward) ;
             rd.forward (req, resp) ;

		 }
	}
	
}
