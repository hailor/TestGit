<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增页面</title>
</head>
<body>
	<center>
		<h3>请输入你要添加的信息</h3>
		<form action="InsertHandle" method="post">
			<table border="1" cellpadding="2" cellspacing="2">
				<tr>
					<td>film_id</td>
					<td>title</td>
					<td>description</td>
					<td>language</td>
				</tr>
				<tr>
					<td><input type="text" name="film_id" /></td>
					<td><input type="text" name="title" /></td>
					<td><input type="text" name="description" /></td>
					<td>
					<select>
						<option >English</option>
						<option>Italian</option>
						<option>Japanese</option>
						<option>Mandarin</option>
						<option>French</option>
						<option>German</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" ><input type="submit" value="提交" /></td>
				</tr>


			</table>

		</form>
	</center>
</body>
</html>