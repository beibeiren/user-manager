<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Form</title>
</head>
<body>
	<!-- 测试EL表达式:传递参数 -->
	<form action="<%=request.getContextPath()%>/training/testEL.jsp">
		name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="name" /><br>
		password:<input name="password"><br>  
		赤<input type="checkbox" name="color" value="color1" />
		橙<input type="checkbox" name="color" value="color2" />
		黄<input type="checkbox" name="color" value="color3" />
		绿<input type="checkbox" name="color" value="color4" />
		青<input type="checkbox" name="color" value="color5" />
		蓝<input type="checkbox" name="color" value="color6" />
		紫<input type="checkbox" name="color" value="color7" /><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>