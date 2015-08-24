package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.ConnectionFactory.ConnectionFactory;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from customer where customer.customer_id='"
					+ id + "'";
			ResultSet rs = st.executeQuery(sql);

			RequestDispatcher rd = null;
			if (rs.next()) {
				request.setAttribute("customer_id", rs.getInt("customer_id"));
				request.setAttribute("store_id", rs.getString("store_id"));
				request.setAttribute("first_name", rs.getString("first_name"));
				request.setAttribute("last_name", rs.getString("last_name"));
				request.setAttribute("email", rs.getString("email"));
				request.setAttribute("address_id", rs.getInt("address_id"));
				request.setAttribute("active", rs.getInt("active"));
				request.setAttribute("create_date", rs.getString("create_date"));

				rd = request.getRequestDispatcher("/jsp/updateCustomer.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "操作失败！");
				rd = request.getRequestDispatcher("/jsp/index.jsp");
				rd.forward(request, response);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
		String store_id = request.getParameter("store_id");
		String active = request.getParameter("active");
		String id = request.getParameter("customer_id");
		
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			String sql = "update customer set first_name=?,last_name=?,address_id=?,email=?,store_id=?,active=? where customer_id='"
					+ id + "'";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, address_id);
			ps.setString(4, email);
			ps.setString(5, store_id);
			ps.setString(6, active);

			ps.execute();
			
			response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
