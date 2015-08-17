<%@page import="com.hand.Bean.Language"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hand.Bean.Film"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Film" scope= "page" class="com.hand.Bean.Film" />
<jsp:setProperty property="*" name="Film" />
<jsp:useBean id="Language" scope= "page" class="com.hand.Bean.Language" />
<jsp:setProperty property="*" name="Language" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% if (request.getAttribute("return_uri") != null) { %>
         <input type ="hidden" name="return_uri"
             value=" <%= request.getAttribute("return_uri" ) %>" >
         <% } %>

<%Film fi = (Film)request.getAttribute("editfilm"); %>
<form action="<%=request.getContextPath()%>/EditServlet" method="post">
		<input type="hidden" name="film_id" value="<%=fi.getFilm_id()%>">
	电影标题：<input type="text" name="title" value="<%=fi.getTitle()%>"><br><br>
	电影简介：<input type="text" name="description" value="<%=fi.getDescription()%>"><br><br>
	当前电影语言：<%=fi.getLanguage()%> <br> <br>
	修改电影语言：<select name="language">
			<%ArrayList<Language> langlist = (ArrayList)request.getAttribute("langlist");
			for(int i =0; i<langlist.size(); i++){%>
			<option><%=langlist.get(i).getName() %></option>
			<%} %>
			</select><br> <br>
	<input type="hidden" name="language_id" value="<%=fi.getLanguage_id()%>">
	<input type="submit" name="submit" value="提交">
</form>
</body>
</html>