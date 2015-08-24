<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="com.hand.ConnectionFactory.ConnectionFactory" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <link type="text/css" rel="stylesheet"
          href="<%=request.getContextPath()%>/css/style.css">

    <title>主页</title>
</head>
<body>

<div class="all">
    <div class="top">
        <span>8835阮荣均</span>
        <%
            if (request.getSession().getAttribute("username") != null) {
        %>
        <span style="float: right;"><a class="btn btn-warning"
                                       href="<%=request.getContextPath()%>/LogoutServlet">退出系统</a></span>
        <span style="float: right;margin-right: 10px;margin-top: 5px;"
              class="glyphicon glyphicon-user"><%=request.getSession().getAttribute("username")%></span>
        <%
            }
        %>
    </div>
    <div class="row">
        <div class="col-md-2">

            <ul class="list-group">
                <li class="list-group-item"><a href="" id="customerClick">Customer管理</a></li>
                <li class="list-group-item">Film管理</li>
            </ul>
        </div>
        <div id="body-right" class="col-md-10">
            <h2>客户管理</h2>
            <span style="font-size: 20px;">客户列表>>></span>
            <button type="button" id="addCustomerBtn" class="btn btn-success">新建</button>
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
                        <th>Customer_id</th>
                        <th>last_update</th>
                    </tr>
                    </thead>

                    <tbody id="tbody">

                    </tbody>
                </table>
            </div>
            <nav>
                <ul class="pagination" id="ByPage">
                </ul>
            </nav>
        </div>
    </div>
</div>
<script type="text/javascript">

    $(document).ready(function () {

        var js_page = 1;
        var js_msg_num = 15;
        var js_msg_len;

        findMessage();


        $("#addCustomerBtn").on("click", function () {
            $("#body-right").text("loading");
            $("#body-right").load("addCustomer.jsp", function (a, status, c) {
                consloe.log(status);
                if (status == "error") {
                    alert("加载失败！");
                }
            });
        });


        function findMessage() {

            $.post("../FindServlet", {
                page: js_page,
                msg_num: js_msg_num
            }, function (data) {
                var objs = eval(data);
                js_msg_len = objs[0].msgLen;
                var tb = $("#tbody");
                tb.empty();
                for (var i = 1; i < objs.length; i++) {
                    tb.append('<tr><td><a data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" href="../UpdateServlet?id=' + objs[i].customer_id + '">编辑</a><div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"><div class="modal-dialog" role="document"><div class="modal-content"></div></div></div>|<a class="js-del" id="' + objs[i].customer_id + '">删除</a></td><td>' + objs[i].first_name + '</td><td>' + objs[i].last_name + '</td><td>' + objs[i].address + '</td><td>' + objs[i].email + '</td><td>' + objs[i].customer_id + '</td><td>' + objs[i].last_update + '</td></tr>');
                }

                var pages = $("#ByPage");
                page_num = Math.ceil(js_msg_len / js_msg_num);
                pages.empty();
                pages.append('<li><a id="Previous">&laquo;</a></li>');
                for (var j = 1; j <= page_num; j++) {
                    pages.append('<li><a class="js-page" id="page' + j + '">' + j + '</a></li>');
                }
                pages.append('<li><a id="Next">&raquo;</a></li>');


                $(".js-del").on("click", function () {
                    var bool = confirm("确认删除吗？");
                    if (bool) {
                        $.get("../DeleteServlet", {
                            id: $(this).attr("id")
                        }, function (data) {
                            findMessage();
                            alert("删除成功！");
                        }).error(function () {
                            alert("删除失败！");
                        });
                    }
                });

                $(".js-page").on("click", function () {
                    var pagenum = $(this).attr("id");
                    js_page = pagenum.substring(4,pagenum.length);
                    findMessage();
                });

                $("#Previous").on("click", function () {
                    if(js_page>1){
                        js_page--;
                        findMessage();
                    }
                    else{
                        $("#Previous").addClass("disable previous");
                    }
                });

                $("#Next").on("click",function(){
                    if(js_page<page_num){
                        js_page++;
                        findMessage();
                    }
                    else{
                        $("#Next").addClass("disable previous");
                    }
                })
                
            }).error(function () {
                alert("error");
            });
        }
    });


</script>
</body>
</html>