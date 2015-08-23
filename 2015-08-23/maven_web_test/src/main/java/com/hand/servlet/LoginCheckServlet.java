package com.hand.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.Bean.Customer;
import com.hand.Bean.Film;
import com.hand.Bean.User;
import com.hand.service.CheckUserLogin;
import com.hand.service.CustomerService;

public class LoginCheckServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6447580429268429387L;
	private CheckUserLogin cku = new CheckUserLogin();
	private CustomerService csc = new CustomerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String uname = req.getParameter ("cname");
		 String password = req.getParameter("password");
		 System.out.println("用户："+uname);
		 RequestDispatcher rd = null;
		 String forward = null;
		 //输入为空
		 if(uname == null||password == null){
			 //req.setAttribute ("msg", "用户名为空");
			 req.getSession().setAttribute("msg", "error");
			 rd = req.getRequestDispatcher("/login.jsp");
			 rd.forward(req, resp);
		 }
		 else
		 {
//			 User user = new User ();
//			 user.setUsername(uname);
			 Customer cus = new Customer();
			 cus.setFirst_Name(uname);
			 cus.setLast_Name(password);
			 boolean bool = csc.check(cus);
			// System.out.println("checkuser:"+bool);
			 ArrayList<Customer> cuslist = csc.getCustomerList();
			 String cuscount=csc.getCustomerCount();
			 Gson gson = new Gson();
			 String json = gson.toJson(cuslist);
			 if(bool){
				 //登录成功 
				 forward = "/index.jsp";
				 req.getSession().setAttribute ("msg", "login");
				 req.getSession().setAttribute("flag", "success");
				 req.setAttribute("cuslist", json);
				 req.setAttribute("cuslist", cuslist);
				 System.out.println("登录成功");
			 }
			 else{
				 //登录失败
				 req.getSession().setAttribute("msg", "error");
				 req.getSession().setAttribute("flag", "error");
				 forward = "login.jsp";
			 }
			 rd = req.getRequestDispatcher (forward) ;
             rd.forward (req, resp) ;

		 }
	}
	
}
