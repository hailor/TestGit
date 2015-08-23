<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>FilmIndex</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
    <!--<link rel="stylesheet" href="bootstrap.min.css">-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
    <div>
        <div class="logo">8814郑晓彬
            <div class="userenter">
                <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                </button>
                User
            </div>
        </div>

        <div class="list-group col-md-2">
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                Dashboard
            </button>
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                应用设置
            </button>
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                管理设置
            </button>
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                数据设置
            </button>
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                主数据设置
            </button>
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                客户订单管理
            </button>
            <button type="button" class="list-group-item">
                <span class="badge">&gt</span>
                发货单管理
            </button>
        </div>

        <div class="col-md-10">
        <div class="usermanagermain">
            <div class="usermanagertitle">
                创建Customer
            </div>
            <hr>
            <div class="info_form">
                <div class="customer_info">
                <p class="text-left title">基本信息</p>
                </div>
                <!-- 表单 -->
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">First Name</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Last Name</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Address</label>
                        <div class="col-sm-10">
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle col-sm-7" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Dropdown
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-6">
                            <button type="submit" class="btn btn-primary">新建</button>
                            <button type="submit" class="btn btn-default">取消</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
        </div>

    </div>
<script src="jquery-2.1.4.min.js"></script>
<script src="bootstrap.min.js"></script>
</body>
</html>