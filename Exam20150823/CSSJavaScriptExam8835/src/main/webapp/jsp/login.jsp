<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link type="text/css" rel="stylesheet"href="<%=request.getContextPath()%>/css/style.css">

    <title>Login</title>
</head>
<body class="body-bg">
<div>
    <h3 class="name">8835阮荣均</h3>
</div>
<div class="container form-class" style="width: 600px;margin-top:100px;">
    <form role="form" class="form-horizontal"
          action="<%=request.getContextPath()%>/LoginServlet" method="post">
        <div class="form-group">
            <div class="login-title">
                <h4>电影租贷系统管理</h4>
            </div>
        </div>

        <%
            if (request.getAttribute("msg") != null) {
        %>
        <div class="form-group">
            <div class="title">
                <strong><%=request.getAttribute("msg")%>
                </strong>
            </div>
        </div>
        <%
            }
        %>

        <div class="form-group row">
            <label class="col-sm-2 control-label">用户名：</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="username" name="username">
                <span class="glyphicon glyphicon-user form-control-feedback" style="right:10px"></span>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label"> 密码：</label>

            <div class="col-sm-10">
                <input type="password" class="form-control" placeholder="password" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback" style="right:10px"></span>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label"></label>

            <div class="col-sm-10">
                <button type="submit" class="btn btn-success">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>