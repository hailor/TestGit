<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/mycss.css" type="text/css">
    <script src="js/jquery-1.11.3.min.js" ></script>
</head>
<body class="login_bj">
<%
	session.invalidate();
%>
<div class="container">
    <div>
        <span>8816 何启谦</span>
    </div>
    <div style="background-color: white;width:400px;height: 150px;margin: 200px auto;">
        <span>电影租借管理系统</span>
        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">用户</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="inputEmail3" value="MARIA">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密 码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="inputPassword3" value="MILLER">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </div>
       </form>
    </div>
</div>
</body>
</html>