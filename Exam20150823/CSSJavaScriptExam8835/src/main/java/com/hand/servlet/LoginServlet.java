package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.ConnectionFactory.ConnectionFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from customer where customer.first_name='" + username + "' and  customer.last_name='" + password + "'";
			ResultSet rs = st.executeQuery(sql);

			RequestDispatcher rd = null;
			if (rs.next()) {
				request.getSession().setAttribute("username", username);
				response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
			} else {
				request.setAttribute("msg", "用户名错误，请重新输入！");
				rd = request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
