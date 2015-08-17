package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterTwo
 */
public class FilterTwo implements Filter {

	public FilterTwo(){
		//System.out.println(" =========	filter_two构造函数	=========" );
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(" =========	filter_two初始化函数	=========" );
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(" =========	filter_two dofilter函数开始	=========" );
		chain.doFilter(request, response);
		System.out.println(" =========	filter_two dofilter函数结束	=========" );
	}
	public void destroy() {
		System.out.println(" =========	filter_two销毁函数	=========" );
	}



}
