package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 要在Build path -- Libraries -- add Libraries 添加要运行的Tomcat所需的包，否则报错无法找到Servlet
 * @author Hubrt
 */
public class LoginServlet extends HttpServlet{
	//生成的序列号版本id,用于序列化和反序列化
	private static final long serialVersionUID = -697203735786881053L;

	@Override
	protected void doGet( HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
		System.out .println( "======== 进入doGet方法 ========" );
		doPost(req , resp);
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException , IOException {
		//实例1
		System.out .println( "======== 进入doPost方法 ========" );
		String userName = req.getParameter ("uname") ;
		String password = req.getParameter ("upwd") ;
		System.out .println( "用户名 ==》 " + userName);
		System.out .println( "密码 ==》 " + password);
		String forward = null;
		if(userName.equals("郑晓彬") && password.equals("hubert")){
			//重定向
			//resp.sendRedirect(req.getContextPath() + "/servlet_login/success.jsp");
			//forward = "http://www.jikexueyuan.com"; //请求转发无法转发到外部链接，但重定向可以跳转到外部链接
			//请求转发
			forward = "/servlet_login/success.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward); //请求调度器：封装了转发的操作，接收来自客户端的请求，转发到指定的资源上
			rd.forward(req, resp); // 实际转发操作
		}
		else{
			//resp.sendRedirect(req.getContextPath() + "/servlet_login/error.jsp");
			//请求转发
			forward = "/servlet_login/error.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}

}



