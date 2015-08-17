<%@page import="java.util.ArrayList"%>
<%@page import="com.hand.Bean.Film"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Film" scope= "page" class="com.hand.Bean.Film" />
<jsp:setProperty property="*" name="Film" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>编辑页面</title>
</head>
<body>
 <% if (request.getAttribute("return_uri") != null) { %>
         <input type ="hidden" name="return_uri"
             value=" <%= request.getAttribute("return_uri" ) %>" >
         <% } %>

	<%
	//String num = request.getAttribute("num").toString();
	ArrayList<Film> filmlist =(ArrayList)request.getAttribute("filmlist");
	for(int i = 0 ; i<filmlist.size();i++){%>
	film_id: <%=filmlist.get(i).getFilm_id() %>,
	title : <%=filmlist.get(i).getTitle() %>,
	Description:<%=filmlist.get(i).getDescription() %>,
	Language:<%=filmlist.get(i).getLanguage() %>
	<a href="<%=request.getContextPath()%>/EditFilmServlet?film_id=<%=filmlist.get(i).getFilm_id()%>">编辑该电影信息</a>
	<br>
	<%	
	}
	%>
</body>
</html>