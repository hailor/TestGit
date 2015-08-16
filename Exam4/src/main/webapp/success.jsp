<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功页面</title>
</head>
<body>
	<div>
		登录成功，欢迎用户 <%=request.getSession().getAttribute("first_name") %> 登录！
		<a href="login.jsp">登录页面</a>
		<a href="FilmShow">film列表页面</a>
	</div>
</body>
</html>