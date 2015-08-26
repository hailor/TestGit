package com.hand.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.Bean.Customer;
import com.hand.service.CustomerService;

public class DelCusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1516402539114713601L;
	private CustomerService csc = new CustomerService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cus_id = req.getParameter("cusid");
		RequestDispatcher rd = null;
		Customer customer = new Customer();
		customer.setCustomer_id(Integer.valueOf(cus_id));
		boolean bool = csc.delCus(customer);
		PrintWriter out = resp.getWriter();
		out.println(bool);
		out.flush();
		out.close();
	}

}
