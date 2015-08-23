<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示电影页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/mycss.css" type="text/css">
</head>
<body>
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
                <li><a href="FilmMainServlet">Custoner管理</a></li>
                <li><a href="FilmIndex.jsp">>Film设置</a></li>
            </ul>
        </div>
    </div>
    <div class="cus">
        <span>客户管理</span>
        <span>客户列表</span>
        <form action="FilmAddServlet" method="post"><input type="submit" value="新建" name="add"></form>
        <div>
            <table class="table table-bordered" style="width:1000px;">
                <%
                ArrayList<HashMap> list = (ArrayList<HashMap>)request.getAttribute("film");
                HashMap map =null;
                for(int i=0; i < list.size();i++){
                map = new HashMap<String,Object>();
                map = (HashMap)list.get(i);
                %>
                <tr>
                <td><a href="FilmUpdateServlet?customer_id=<%=map.get("customer_id").toString() %>">编辑</a>
                <td><a href="FilmDeleteServlet?customer_id=<%=map.get("customer_id").toString() %>">删除</a>
                    <td><%= map.get("first_name").toString()%></td>
                    <td><%= map.get("last_name").toString()%></td>
                    <td><%= map.get("address").toString()%></td>
                    <td><%= map.get("email").toString()%></td>
                    <td><%= map.get("customer_id").toString()%></td>
                    <td><%= map.get("last_update").toString()%></td>

                </tr>

                <% } %>



            </table>
            <nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>