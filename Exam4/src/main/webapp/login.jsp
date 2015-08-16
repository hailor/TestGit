<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login页面</title>
</head>

<%=request.getAttribute("flag") %>
<script type="text/javascript">
	function check(form){
		if(document.forms.loginForm.uname.value==""){
			alert("请输入用户名！");
			document.forms.loginForm.uname.focus();
		}
	}

</script>

<body>

	
	<form action="LoginServlet" method="post" name="loginForm">
	<table border="1" cellpadding="5" cellspacing="0" bordercolor="silver" align="center">
		<tr>	
			<td colspan="2" align="center" bgcolor="#e8e8e8">请输入firstName</td>
		</tr>
		<tr>
			<td>first_name：</td>
			<td><input type="text" name="firstName"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="login" onclick="return check(this);"/>
				<input type="reset" name="reset"/>
			</td>
		</tr>
	
	</table>
	
	</form>
</body>
</html>