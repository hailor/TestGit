package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.ConnectionFactory;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String first_name = request.getParameter("first_name");
		if(first_name != null){
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			String sql = "SELECT * FROM customer WHERE first_name=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, first_name);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					request.getSession().setAttribute("first_name", first_name);
					response.sendRedirect("success.jsp");
				}
				PrintWriter out = response.getWriter();
				out.println("<script>alert('登录失败，用户名错误，请重新登录！');history.go(-1);</script>");
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}