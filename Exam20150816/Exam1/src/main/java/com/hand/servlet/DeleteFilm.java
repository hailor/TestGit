package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.ConnectionFactory.ConnectionFactory;

/**
 * Servlet implementation class DeleteFilm
 */
public class DeleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFilm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			int id = Integer.parseInt(request.getParameter("id"));
			// String sql = "delete from film where film_id=" + id;
			// st.addBatch("delete from film_actor where film_id=" + id);
			// st.addBatch("delete from film_category where film_id=" + id);
			// st.addBatch(
			// "delete from rental where inventory_id in(select inventory_id
			// from inventory where film_id=" + id);
			// st.addBatch("delete from inventory where film_id=" + id);
			// st.addBatch("delete from film where film_id=" + id);
			// st.executeBatch();

			PreparedStatement ps = null;
			String sql = null;

			sql = "delete from film_actor where film_id=?";
			ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			sql = "delete from film_category where film_id=?";
			ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			sql = "delete from rental where inventory_id in(select inventory_id from inventory where film_id=?)";
			ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			sql = "delete from inventory where film_id=?";
			ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			sql = "delete from film where film_id=?";
			ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			conn.close();

			RequestDispatcher rd = null;
			request.setAttribute("message", "删除成功！");
			rd = request.getRequestDispatcher("/jsp/filmMessages.jsp");
			rd.forward(request, response);

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

		doGet(request, response);
	}

}
