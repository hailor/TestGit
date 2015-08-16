<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增电影页面</title>
</head>
<body>
<%
HashMap<String , Object> map = (HashMap)request.getAttribute("filmMap");
ArrayList<String> list = (ArrayList)request.getAttribute("languageList");
%>
<form action="FilmAddDoServlet" method="post">
title：<input type="text" name="title"  /><br/>
description：<input type="text" name="description" /><br/>
language：<select name="language">
		<%
			for(int i = 0;i < list.size();i++){
		%>
				<option ><%=list.get(i) %></option>
				
				<%  } %>
		
	</select><br/>
<input type="submit" value="Add"/><br/>
<input type="reset" value="Reset"/>
</form>
</body>
</html>