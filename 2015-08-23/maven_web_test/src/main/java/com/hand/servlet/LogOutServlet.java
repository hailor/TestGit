package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3280120211488871045L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//删除Session对象
		req.getSession().invalidate();
		//重定向跳转会首页
		resp.sendRedirect(req.getContextPath() + "login.jsp");
	}
	
}
