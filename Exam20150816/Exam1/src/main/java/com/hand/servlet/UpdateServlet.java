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
			String sql = "select * from film where film.film_id='"
					+ id + "'";
			ResultSet rs = st.executeQuery(sql);

			RequestDispatcher rd = null;
			if (rs.next()) {
				request.setAttribute("film_id", rs.getInt("film_id"));
				request.setAttribute("title", rs.getString("title"));
				request.setAttribute("description", rs.getString("description"));
				request.setAttribute("language_id", rs.getInt("language_id"));
				request.setAttribute("rental_duration", rs.getInt("rental_duration"));
				request.setAttribute("rental_rate", rs.getInt("rental_rate"));
				request.setAttribute("replacement_cost", rs.getInt("replacement_cost"));

				rd = request.getRequestDispatcher("/jsp/filmUpdate.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "操作失败！");
				rd = request.getRequestDispatcher("/jsp/filmMessages.jsp");
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

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");
		String id = request.getParameter("film_id");
		String rental_duration = request.getParameter("rental_duration");
		String rental_rate = request.getParameter("rental_rate");
		String replacement_cost = request.getParameter("replacement_cost");

		System.out.println(title+" "+description+" "+" "+language+" "+rental_duration+" "+" "+rental_rate+" "+replacement_cost);
		
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			String sql = "update film set film.title=?,film.description=?,film.language_id=?,film.rental_duration=?,film.rental_rate=?,film.replacement_cost=? where film.film_id='"
					+ id + "'";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, language);
			ps.setInt(4, Integer.parseInt(rental_duration));
			ps.setString(5, rental_rate);
			ps.setString(6, replacement_cost);

			RequestDispatcher rd = null;
			ps.execute();
			request.setAttribute("message", "修改成功！");
			rd = request.getRequestDispatcher("/jsp/filmMessages.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
