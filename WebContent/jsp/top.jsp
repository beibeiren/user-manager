<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="com.training.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>top</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<font class="welcome">
	  登录成功，欢迎
	<%-- 从session内置对象中获取session保存的用户名 --%>
	<% String sessionUsername = (String)session.getAttribute("sessionUsername"); %>
	<%=sessionUsername + "," %>
	<%-- 从request内置对象中 获取客户端请求的参数值 --%>
	<% String requestUsername = request.getParameter("requestUsername");%>
	<%=requestUsername + "," %>
	<%-- 从request内置对象中获取servlet传递的用户名 --%>
	<% String servletUsername = (String)request.getAttribute("servletUsername"); %>
	<%=servletUsername %>
	</font>
  	<h1>添加用户</h1>
  	<form action="add" method="post">
		<div class="container">
		<table>
			<tr><td><label>用户名：</label></td><td><input type="text" name="username" /></td></tr>
			<tr><td><label>密&nbsp;&nbsp;&nbsp;码：</label></td><td><input type="password" name="password" /></td></tr>
		</table>
		<input type="submit" value="添加用户">
		</div>
	</form>
	<% List<User> userList = (List<User>)request.getAttribute("userList"); %>
	<h1>用户列表</h1>
	<table>
		<tr><th>用户名</th><th>创建时间</th><th>操作</th></tr>
		<% for(User user: userList) { %>
			<tr>
				<td><%=user.getUsername()%></td>
				<td><%=user.getCreatedTime() %></td>
				<td>
					<input type="button" value="修改"/>
					<input type="button" value="删除"/>
				</td></tr>
		<% } %>
	</table>
</body>
</html>