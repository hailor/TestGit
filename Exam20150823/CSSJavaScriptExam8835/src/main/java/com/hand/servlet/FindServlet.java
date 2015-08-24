package com.hand.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.ConnectionFactory.ConnectionFactory;

/**
 * Servlet implementation class FindServlet
 */
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindServlet() {
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
		try {
			String sql = "select * from customer,address where customer.address_id=address.address_id";
			Connection conn = ConnectionFactory.getInstance().getConnection();
			Statement st;
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			JsonArray json = new JsonArray();
//			String json="[";
//			String json ="{\"value\":\"xx\",\"row\":1,\"col\":1}";      
			while(rs.next()){
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("first_name", rs.getString("first_name"));
				jsonObject.addProperty("last_name", rs.getString("last_name"));
				jsonObject.addProperty("address", rs.getString("address"));
				jsonObject.addProperty("email", rs.getString("email"));
				jsonObject.addProperty("customer_id", rs.getString("customer_id"));
				jsonObject.addProperty("last_update", rs.getString("last_update"));
				json.add(jsonObject);
//				json+="{\"first_name\":\""+rs.getString("first_name")+"\",\"last_name\":\""+rs.getString("last_name")+"\",\"address\":\""+rs.getString("address")+"\",\"email\":\""+rs.getString("email")+"\",\"customer_id\":\""+rs.getString("customer_id")+"\",\"last_update\":\""+rs.getString("last_update")+"\"},";
			}
//			json = json.substring(0,json.length()-1)+"]";
			
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
