<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增客户页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/mycss.css" type="text/css">
</head>
<body>
<%
HashMap<String , Object> map = (HashMap)request.getAttribute("filmMap");
    ArrayList<String> list = (ArrayList)request.getAttribute("addressList");
        %>
<div class="container">
    <div style="background-color: dodgerblue">
        <span>8816 何启谦</span>
        <a href="login.jsp"><div style="display: inline; ">
            <img src="img/bj.jpg" style="width: 40px;height: auto;">
            <span>admin</span>
        </div></a>
    </div>
    <div class="menu">
        <div>
            <ul>
                <li>应用设置</li>
                <li>应用设置</li>
                <li>应用设置</li>
                <li>应用设置</li>
                <li>应用设置</li>
                <li>应用设置</li>
            </ul>
        </div>
    </div>
    <div class="cus">
        <span>创建Customer</span>
        <p>基本信息</p>
        <div style="width: 800px;">
            <form class="form-horizontal" action="FilmAddDoServlet" method="post">
                <div class="form-group">
                    <label for="first" class="col-sm-2 control-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="first" name="first_name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="last" class="col-sm-2 control-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="last" name="last_name" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" name="email" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">Address</label>
                    <div class="col-sm-10">
                        <select  class="form-control" id="address" name="address" >
                            <%
                            for(int i = 0;i < list.size();i++){
                            %>
                            <option ><%=list.get(i) %></option>

                            <%  } %>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">新建</button>
                        <button type="reset" class="btn btn-default">取消</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>