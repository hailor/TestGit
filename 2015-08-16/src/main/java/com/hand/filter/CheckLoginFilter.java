package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public CheckLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httprequest = (HttpServletRequest)request;
		HttpServletResponse httpresponse = (HttpServletResponse)response;

		String servletPath = httprequest.getServletPath ();

		HttpSession session = httprequest.getSession();
		String flag = ""; 
		flag = (String) session.getAttribute ("flag");
		if(servletPath!=null &&(servletPath.equals("/login/login.jsp")||servletPath.equals("/LoginCheckServlet")))
		{
			chain.doFilter(request, response);
		}
		else{
			if(flag!=null&&flag.equals("success"))
			{
				//成功登录过的用户
				chain.doFilter(httprequest, httpresponse);
			}
			else {
				httprequest.getSession().setAttribute ("msg", "error");
				httprequest.setAttribute ("return_uri", servletPath);
				RequestDispatcher rd = httprequest.getRequestDispatcher("/login/login.jsp");
				rd.forward (httprequest, httpresponse);
			}
		}
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}



}
