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
<title>所有的Film信息</title>
</head>
<body>
	<h2>所有的Film信息</h2>
	<a href="<%=request.getContextPath()%>/jsp/filmAdd.jsp">新增Film信息</a>||
	<a href="<%=request.getContextPath()%>/jsp/index.jsp">返回主页</a>
	<%
		if(request.getAttribute("message")!=null){
			%>
			Message:<%=request.getAttribute("message") %>
			<% 
		}
	%>
	<table border="1">
		<tr>
			<th>film_id</th>
			<th>title</th>
			<th>description</th>
			<th>language</th>
			<th>操作</th>
		</tr>
		<%
			String sql = "SELECT film.film_id,film.title,film.description,language.name FROM film INNER JOIN language ON film.language_id = language.language_id";
			Connection conn = ConnectionFactory.getInstance().getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("film_id")%></td>
			<td><%=rs.getString("title")%></td>
			<td><%=rs.getString("description")%></td>
			<td><%=rs.getString("name")%></td>
			<td><a
				href="<%=request.getContextPath()%>/UpdateServlet?id=<%=rs.getString("film_id")%>">编辑</a>||<a
				href="<%=request.getContextPath()%>/DeleteFilm?id=<%=rs.getString("film_id")%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>