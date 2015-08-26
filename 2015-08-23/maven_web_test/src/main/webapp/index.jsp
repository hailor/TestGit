<%@page import="java.util.ArrayList"%>
<%@page import="com.hand.Bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>index</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    <!--<link rel="stylesheet" href="bootstrap.min.css">-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div>
<div class="logo">8814郑晓彬

    <!-- Single button -->
	<div class="btn-group userenter">
  		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    		User<span class="glyphicon glyphicon-user"></span> <span class="caret"></span>
  		</button>
  		<ul class="dropdown-menu">
    		<li role="separator" class="divider"></li>
    		<li><a href="<%=request.getContextPath()%>/LoginCheckServlet">Logout</a></li>
 		 </ul>
	</div>
    
</div>


        <!--导航列表-->
  <!--  <div class="toollist list-group col-md-2">
        <button type="button" class="list-group-item">
            <span class="badge">&gt</span>
            Customor管理</button>
        <button type="button" class="list-group-item">
            <span class="badge">&gt</span>
            Film设置
        </button>
    </div>-->
    <div class="toollist col-md-2">
 <ul class="list-group">
  <li class="list-group-item"><span class="badge">&gt</span><a href="index.jsp">Customor管理</a></li>
  <li class="list-group-item"><span class="badge">&gt</span><a href="filmindex.jsp">Film设置</a></li>

</ul>
    </div>

    <div class="container col-md-10">
        <!-- 主体内容 -->
        <div class="usermanagertitle">
            客户管理
        </div>
        <div class="usermanagermain">

            <p class="text-left">客户列表
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-primary" role="button" href="filmindex.jsp">新建</a>
            </p>
        </div>
        
        <!-- 主体内容 -->
              <div class="usertable col-md-12">
                <table class="table table-bordered col-md-12">
                    <th>操作</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Customerid</th>
                    <th>lastupdate</th>
                    <%
                    ArrayList<Customer> cuslist =(ArrayList)request.getAttribute("cuslist"); 
                    for(int i = 0 ; i < cuslist.size();i++){
                    
                    %>
                    <tr>
                        <td><a href="#" class="edit">编辑</a>|<a href="#" class="del">删除</a></td>
                        <td><%=cuslist.get(i).getFirst_Name()%></td>
                        <td><%=cuslist.get(i).getLast_Name()%></td>
                        <td><%=cuslist.get(i).getAddress() %></td>
                        <td><%=cuslist.get(i).getEmail() %></td>
                        <td class="cus_id"><%=cuslist.get(i).getCustomer_id() %></td>
                        <td><%=cuslist.get(i).getLastUpdate() %></td>
                    </tr>
                    <%	
					}
					%>
                </table>
                <!-- 分页 -->
                <div class="fenye">
                    <ul class="pagination">
                    <%
					String paging = (String)request.getAttribute("paging");
                    int countpage = Integer.valueOf(paging)/10;
					%>
                        <li>
                        	
                            <a class="last_page" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <%for(int i=1;i<countpage;i++){ %>
                        <li><a id="<%=i%>" href="#" class="paging"><%=i%></a></li>
                         <% }%>
                        <li>
                            <a class="next_page" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                       
                    </ul>
	                    

                </div>
            </div>
        
    </div>
</div>
<script src="JS/jquery-2.1.4.min.js"></script>
<script src="JS/bootstrap.min.js"></script>
<script src="JS/jquery-ui.min.js"></script>
<script src="JS/jPaginator-min.js"></script>
<script src="JS/myjs.js"></script>
<script type="text/javascript">
/*
$(document).ready(function(){
	//分页栏的点击事件
	$(".fenye").find("a").click(function(){
		var page_num = $(this).text();
		console.log(page_num);
		//var test = <%=request.getContextPath()%>+"/GetCusListServlet";
		//拼接url
		 <%
		 String path = request.getContextPath();
		 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/GetCusListServlet?pagestart=";
		 %>
		var urlpage = <%=basePath%>;
		//console.log(<%=basePath%>);
		$.ajax({
			url:urlpage+page_num,
			dataType:'json',
			error:function(){console.log("ajax,error!")},
			success:function(json)
			{
				console.log(json);
				var json_obj = JSON.parse(json);
				if (json_obj.length) {
					//遍历
					var str ="";
					$.each(json_obj,function(index,array){
						//将数据插入到表格中
						str = '<tr>';
						str += '<td><a>编辑</a>|<a>删除</a></td>';
						str += '<td>'+array.Fisrt_Name+'</td>';
						str += '<td>'+array.Last_Name+'</td>';
						str += '<td>'+array.Address+'</td>';
						str += '<td>'+array.Email+'</td>';
						str += '<td>'+array.LastUpdate+'</td>';
						str += '</tr>';
						$("table").empty();
						$("table").append(str);
					});
				}
			
			}
		});
	});
	
})
*/
</script>
</body>
</html>