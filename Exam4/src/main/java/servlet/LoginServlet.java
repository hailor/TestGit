package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.DaoImp;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DaoImp daoimp = new DaoImp();
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		RequestDispatcher rd = null;
		if (firstName.equals(daoimp.selectFirstName(firstName))) {
			request.getSession().setAttribute("flag", "login_error");
			rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}else{
			request.getSession().setAttribute("msg", "用户名或者密码错误！！！");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
