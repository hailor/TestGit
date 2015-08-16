<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示电影页面</title>
</head>
<body>
<table>
<%
	ArrayList<HashMap> list = (ArrayList<HashMap>)request.getAttribute("film");
	HashMap map =null;
	for(int i=0; i < list.size();i++){
		map = new HashMap<String,Object>();
		map = (HashMap)list.get(i);
%>
		<tr>
		<td><%= map.get("film_id").toString()%></td>
		<td><%= map.get("title").toString()%></td>
		<td><%= map.get("description").toString()%></td>
		<td><%= map.get("language").toString()%></td>
		<td><a href="FilmAddServlet">新增</a>
		<td><a href="FilmDeleteServlet?film_id=<%=map.get("film_id").toString() %>">删除</a>
		<td><a href="FilmUpdateServlet?film_id=<%=map.get("film_id").toString() %>">编辑</a>
		</tr>

<% } %>



</table>
</body>
</html>