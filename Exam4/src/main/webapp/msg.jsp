<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<script>
	msg = document.getElementById("msg").value();
	alert(msg);
	history.go(-1);
</script>
<body>
	<%
		String msg = request.getParameter("msg");
	%>
	<input type="hidden" value="<%=msg %>" id="msg"/>
</body>
</html>