<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
</head>
<body>
 <% if (request.getAttribute("return_uri") != null) { %>
         <input type ="hidden" name="return_uri"
             value=" <%= request.getAttribute("return_uri" ) %>" >
         <% } %>

	<a href="login/login.jsp">登录界面</a> <br><br>
	<a href="<%=request.getContextPath()%>/GetFilmListServlet?del=getlist">列表显示界面</a> <br><br>
	<a href="<%=request.getContextPath()%>/GetLangServlet">新增界面</a> <br><br>
	<a href="<%=request.getContextPath()%>/GetFilmListServlet?del=del">删除界面</a> <br><br>
	<a href="<%=request.getContextPath()%>/GetFilmListServlet?del=edit">编辑功能</a> <br><br>
</body>
</html>