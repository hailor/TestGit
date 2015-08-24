<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<div align="center">
		<h2>主页</h2>
		<%
			if (request.getSession().getAttribute("username") != null) {
		%>
		<p style="color: blue;">
			欢迎用户<%=request.getSession().getAttribute("username")%>登录
		</p>
		<%
			}
		%>
		<a href="<%=request.getContextPath()%>/LogoutServlet">注销</a><br>
		<a href="<%=request.getContextPath()%>/jsp/filmMessages.jsp">查看所有Film信息</a><br>
		<a href="<%=request.getContextPath()%>/jsp/filmAdd.jsp">新增Film信息</a>
	</div>
</body>
</html>