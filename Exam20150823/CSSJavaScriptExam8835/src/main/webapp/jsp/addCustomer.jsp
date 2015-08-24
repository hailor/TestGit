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
    <title>Insert title here</title>
</head>
<body>
<h3>创建Customer</h3>
<form role="form" class="form-horizontal" action="<%=request.getContextPath()%>/AddServlet" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label has-feedback">First_name：<span style="color: red;">*</span></label>

        <div class="col-sm-10">
            <input type="text" class="form-control" placeholder="First_name" name="first_name">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label has-feedback">Last_name：<span style="color: red;">*</span></label>

        <div class="col-sm-10">
            <input type="text" class="form-control" placeholder="Last_name" name="last_name">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label has-feedback">Email：</label>

        <div class="col-sm-10">
            <input type="email" class="form-control" placeholder="email" name="email">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Address：<span style="color: red;">*</span></label>

        <div class="col-sm-10">
            <select class="form-control" name="address_id">
                <%
                    String sql = "select * from address";
                    Connection conn = ConnectionFactory.getInstance().getConnection();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                %>
                <option value="<%=rs.getInt("address_id")%>"><%=rs.getString("address")%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="submit" class="btn btn-success">新建</button>
            <a class="btn btn-warning" href="<%=request.getContextPath()%>/jsp/index.jsp">取消</a>
        </div>
    </div>
</form>
</body>
</html>