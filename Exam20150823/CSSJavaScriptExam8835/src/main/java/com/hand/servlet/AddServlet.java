package com.hand.servlet;

import java.awt.image.TileObserver;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.ConnectionFactory.ConnectionFactory;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address_id = request.getParameter("address_id");
		String email = request.getParameter("email");

		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			Statement st = conn.createStatement();
			String sql = "insert customer(first_name,last_name,address_id,email,store_id,active,create_date) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, address_id);
			ps.setString(4, email);
			ps.setString(5, "1");
			ps.setString(6, "1");
			ps.setString(7, "2015-08-23 22:04:36");


			RequestDispatcher rd = null;
			ps.execute();
			request.setAttribute("message", "添加成功！");
			rd = request.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
