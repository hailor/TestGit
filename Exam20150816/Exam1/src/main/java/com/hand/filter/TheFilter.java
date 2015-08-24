package com.hand.filter;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TheFilter
 */
public class TheFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public TheFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (req.getSession().getAttribute("username") != null || req.getServletPath().equals("/LoginServlet")
				|| req.getServletPath().equals("/jsp/login.jsp")) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("msg", "请先登录，再操作！");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(req, resp);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
