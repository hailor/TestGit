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

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");

		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			Statement st = conn.createStatement();
			String sql = "insert film(title,description,language_id,rental_duration,rental_rate,replacement_cost) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, language);
			ps.setString(4, "1");
			ps.setString(5, "1");
			ps.setString(6, "1");

			RequestDispatcher rd = null;
			ps.execute();
			request.setAttribute("message", "添加成功！");
			rd = request.getRequestDispatcher("/jsp/filmMessages.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
