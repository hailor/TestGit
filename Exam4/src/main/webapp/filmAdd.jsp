<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*,entity.Language" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增电影</title>
<script type="text/javascript">
	function check(form){
		if(document.forms.filmForm.title.value == ""){
			alert("名称不能为空！");
			document.forms.filmForm.title.focus();
			return false;
		}else if(document.forms.filmForm.language_id.value == ""){
			alert("未选择语言！");
			return false;
		}
	}
</script>
</head>
<%
	List<Language> list = (List)request.getAttribute("list");
%>
<body>
	<form action="<%=request.getContextPath() %>/FilmAdd2" method="post" name="filmForm"><!-- CheckServlet -->
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">用户登录</td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td>描述</td>
				<td>
					<textarea name="description" rows="5" cols="70"></textarea>
				</td>
			</tr>
			<tr>
				<td>语言</td>
				<td>
				<%
					for(Language language : list){
				%>
					<input type="radio" name="language_id" value="<%=language.getLanguage_id() %>"/><%=language.getName() %>
				<%} %>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" onclick="return check(this);"/>
					<input type="reset"/>
				</td>
			</tr>
		</table>
</body>
</html>