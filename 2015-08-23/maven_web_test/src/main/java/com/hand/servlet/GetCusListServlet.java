package com.hand.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hand.Bean.Customer;
import com.hand.service.CustomerService;

public class GetCusListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2326691786459366305L;
	private CustomerService csc = new CustomerService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pagingstart = req.getParameter("pagestart");
		ArrayList<Customer> cuslist = csc.getCustomerListStart(Integer.valueOf(pagingstart)*10);
		Gson gson = new Gson();
		String json = gson.toJson(cuslist);
		PrintWriter out = resp.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
	
	

}
