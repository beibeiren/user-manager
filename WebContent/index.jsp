<!-- 告诉tomcat容器使用utf-8编码格式（服务器端） -->
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 告诉浏览器使用utf-8编码格式（客户端） -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/style.css">
<title>login</title>
</head>
<body>
	<h1>用户登录</h1>
	<form action="login" method="post">
		<div class="container">
		<table>
			<tr><td><label>用户名：</label></td><td><input type="text" name="username" /></td></tr>
			<tr><td><label>密&nbsp;&nbsp;&nbsp;码：</label></td><td><input type="password" name="password" /></td></tr>
		</table>
		<input type="submit" value="登录">
		</div>
	</form>
</body>
</html>