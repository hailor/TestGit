package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		String flag = (String)request.getAttribute("flag");
		RequestDispatcher rd = null;
		System.out.println(flag);
		if(flag!=null){
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
}
