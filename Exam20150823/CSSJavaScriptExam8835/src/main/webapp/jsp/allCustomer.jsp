<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="com.hand.ConnectionFactory.ConnectionFactory" %>
<%@page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <link rel="stylesheet"
          href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <link type="text/css" rel="stylesheet"
          href="<%=request.getContextPath()%>/css/style.css">
    <title>所有的Film信息</title>
</head>
<body>
<h2>客户管理</h2>
<strong style="font-size: 15px;">客户列表>>></strong>
<a class="btn btn-success" href="<%=request.getContextPath()%>/jsp/addCustomer.jsp">新建</a>

<div class="table-bordered">
    <table class="table table-condensed table-striped">
        <thead>
        <%
            if (request.getAttribute("message") != null) {
        %>
        Message:<%=request.getAttribute("message")%>
        <%
            }
        %>

        <tr>
            <th>操作</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>address</th>
            <th>email</th>
            <th>create_date</th>
            <th>last_update</th>
        </tr>
        </thead>
        <%
            String sql = "SELECT * FROM customer,address where customer.address_id=address.address_id";
            Connection conn = ConnectionFactory.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
        %>
        <tbody>
        <tr>
            <td><a
                    href="<%=request.getContextPath()%>/UpdateServlet?id=<%=rs.getString("customer_id")%>">编辑</a>|<a
                    href="<%=request.getContextPath()%>/DeleteFilm?id=<%=rs.getString("customer_id")%>">删除</a>
            </td>
            <td><%=rs.getString("first_name")%>
            </td>
            <td><%=rs.getString("last_name")%>
            </td>
            <td><%=rs.getString("address")%>
            </td>
            <td><%=rs.getString("email")%>
            </td>
            <td><%=rs.getString("create_date")%>
            </td>
            <td><%=rs.getString("last_update")%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<nav>
    <ul class="pagination">
        <li class="disabled"><a href="#">&laquo;</a></li>
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
</nav>
</body>
</html>