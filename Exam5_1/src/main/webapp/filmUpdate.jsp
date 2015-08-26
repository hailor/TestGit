<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改电影页面</title>
</head>
<body>
<%
HashMap<String , Object> map = (HashMap)request.getAttribute("filmMap");
ArrayList<String> list = (ArrayList)request.getAttribute("languageList");
%>
<form action="FilmUpdateDoServlet" method="post">
<input type="hidden" name="customer_id" value=<%="\""+map.get("customer_id").toString()+"\"" %> />

	
	
	<div class="form-group">
                    <label for="first" class="col-sm-2 control-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="first" name="first_name" value=<%="\""+map.get("first_name").toString()+"\"" %>>
                    </div>
                </div>
                <div class="form-group">
                    <label for="last" class="col-sm-2 control-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="last" name="last_name" value=<%="\""+map.get("last_name").toString()+"\"" %>>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" name="email" value=<%="\""+map.get("email").toString()+"\"" %>>
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
	
<input type="submit" value="Update"/><br/>
<input type="reset" value="Reset"/>
</form>
</body>
</html>