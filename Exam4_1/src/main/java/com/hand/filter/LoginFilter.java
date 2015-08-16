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

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;  
		  HttpServletResponse res = (HttpServletResponse) response;  
		  HttpSession session = req.getSession(true);  
		  Object ob = session.getAttribute("flag");
		  System.out.println(req.getRequestURI());
		  if(req.getRequestURI().equals("/Exam4_1/login.jsp") || req.getRequestURI().equals("/Exam4_1/LoginServlet") || req.getRequestURI().equals("/Exam4_1/index.jsp")){
			  chain.doFilter(request, response);
		  }
		  else if(ob == null){
			  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
		  } 
		  else if(!ob.toString().equals("login")){
			  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
		  }
		  else{
			  chain.doFilter(request, response);
		  }
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
