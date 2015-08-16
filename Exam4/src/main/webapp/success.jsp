<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功页面</title>
</head>
<body>

<a href="index.jsp">index页面</a>
	<center>

		<h3>你好，登录成功</h3>
		以下是film表中的信息<br />
		<form action="SuccessHandle" method="post" >
		<table border="1" cellpadding="2" cellspacing="3">
			<jsp:useBean id="daoimp" class="dao.imp.DaoImp"></jsp:useBean>
			<tr>
				<td>film_id</td>
				<td>title</td>
				<td>description</td>
				<td>language</td>
				<td>删除操作</td>
			</tr>
			<%
				ResultSet rs = daoimp.showFilmAllInfo();
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%><input type="hidden" value="<%=rs.getInt(1)%>" name="a"/></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(18)%></td>
				<td><input type="submit" value="删除" name="film_id"/></td>
			</tr>
			<%
				}
			%>

		</table>
		</form>
	</center>
	<%request.getSession().setAttribute("flag","login"); %>
</body>
</html>