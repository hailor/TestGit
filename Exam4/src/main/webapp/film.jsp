<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Film,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影展示页面</title>
</head>
<%
	List<Film> list = (List)request.getAttribute("list");
%>
<body>
	<div>
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="5" align="center" bgcolor="#E8E8E8">
					电影列表
					<a href="FilmAdd" style="float:right;">新增电影</a>
				</td>
			</tr>
			<tr>
				<th>ID</th>
				<th>名称</th>
				<th>描述</th>
				<th>语言</th>
				<th>操作</th>
			</tr>
			<%
				for(Film film : list){
			%>
				<tr>
					<td><%=film.getFilm_id() %></td>
					<td><%=film.getTitle() %></td>
					<td><%=film.getDescription() %></td>
					<td><%=film.getName() %></td>
					<td>
						<a href="FilmDel?film_id=<%=film.getFilm_id() %>">删除</a>
						<a href="FilmEdit?film_id=<%=film.getFilm_id() %>">编辑</a>
					</td>
				</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>