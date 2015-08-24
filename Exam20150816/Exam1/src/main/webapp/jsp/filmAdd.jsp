<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.hand.ConnectionFactory.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增Film信息</title>
</head>
<body>
	<div align="center">
		<h2>新增Film信息</h2>
		<form action="<%=request.getContextPath()%>/AddServlet" method="post">
			<table>
				<tr>
					<td>title：</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>description：</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>language：</td>
					<td><select name="language">
							<%
								String sql = "select * from language";
								Connection conn = ConnectionFactory.getInstance().getConnection();
								Statement st = conn.createStatement();
								ResultSet rs = st.executeQuery(sql);
								while (rs.next()) {
							%>
							<option value="<%=rs.getInt("language_id")%>"><%=rs.getString("name")%></option>
							<%
								}
							%>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="提交"> <a
				href="<%=request.getContextPath()%>/jsp/filmMessages.jsp">返回</a>
		</form>
	</div>
</body>
</html>