package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterOne
 */
public class FilterOne implements Filter {
	public String charEncoding = null ; //当前应用的字符集名称
	/**
	 * Default constructor. 
	 */
	public FilterOne() {
		
		//System.out.println(" =========	filter_one构造函数	=========" );
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//Servlet容器启动的时候，会执行过滤器的init方法，servlet在第一次被访问时才执行
		//FilterConfig是一个用来获取过滤器初始化配置信息的接口，
		System.out.println("=========	filter_one初始化方法	=========");
		//获取初始化参数,getinitParameter方法:返回以参数param命名的初始化参数的值，返回字符串类型，若参数不存在，则返回null
		String initParam = fConfig.getInitParameter("param");
		//打印参数
		//System.out.println("=======  第一个过滤器初始化参数 name = param; value = " + initParam + " ======= ");
		//从web.xml里获取name为Encoding的参数
		charEncoding = fConfig.getInitParameter("Encoding");
		if(charEncoding == null) {
			throw new ServletException("EncodingFilter中编码设置为空");
		}
	}

	/**
	 * FilterChain提供了一个doFilter，开发人员可根据业务需要决定是否调用，调用后，servlet容器会将请求和响应转发给下一个组件进行处理，不调用的话就不进行后续的处理，
	 * 下一个组件可以是过滤器或servlet或其他的web组件
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	//
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("=========	filter_one dofilter方法开始	=========");
		//若当前编程与请求中的编码设置不一致，则将请求中的编程设置为当前的编码方式，
		if(!charEncoding.equals(request.getCharacterEncoding())){
			request.setCharacterEncoding(charEncoding);
		}
		//将响应信息中的编码也设置为当前的编码方式
		response.setCharacterEncoding(charEncoding);
		
		chain.doFilter(request, response);
		System.out.println("=========	filter_one dofilter方法结束	=========");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("=========	filter_one销毁方法	=========");
	}


}
