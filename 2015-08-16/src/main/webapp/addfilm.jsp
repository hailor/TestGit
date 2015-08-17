<%@page import="com.hand.Bean.Language"%>
<%@page import="com.hand.Bean.Film"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Lang" scope= "page" class="com.hand.Bean.Language" />
<jsp:setProperty property="*" name="Lang" />
<jsp:useBean id="Film" scope= "page" class="com.hand.Bean.Film" />
<jsp:setProperty property="*" name="Film" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>新增页面</title>
</head>

<body>
	<form action="<%=request.getContextPath()%>/AddFilmServlet" method="post">
	 <% if (request.getAttribute("return_uri") != null) { %>
         <input type ="hidden" name="return_uri"
             value=" <%= request.getAttribute("return_uri" ) %>" >
         <% } %>
	电影标题：	<input type="text" name="title" ><br><br>
	电影简介： <input type="text" name="description"><br><br>
	电影语言：<select name="language">
			<%ArrayList<Language> langlist = (ArrayList)request.getAttribute("langlist");
			for(int i =0; i<langlist.size(); i++){%>
			<option><%=langlist.get(i).getName() %></option>
			<%} %>
			<br><br>
	<input type="submit" name="submit" value="提交">
	</form>
</body>
</html>