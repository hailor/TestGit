<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<div align="center">
		<h2>用户登录</h2>
		<%
			if (request.getAttribute("msg") != null) {
		%>
		<%=request.getAttribute("msg")%>
		<%
			}
		%>
		<form action="<%=request.getContextPath()%>/LoginServlet"
			method="post">
			name:<input type="text" name="username"> <br> <input
				type="submit" value="登录">
		</form>
	</div>
</body>
</html>