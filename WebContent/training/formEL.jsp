<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Form</title>
</head>
<body>
	<!-- ����EL���ʽ:���ݲ��� -->
	<form action="<%=request.getContextPath()%>/training/testEL.jsp">
		name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="name" /><br>
		password:<input name="password"><br>  
		��<input type="checkbox" name="color" value="color1" />
		��<input type="checkbox" name="color" value="color2" />
		��<input type="checkbox" name="color" value="color3" />
		��<input type="checkbox" name="color" value="color4" />
		��<input type="checkbox" name="color" value="color5" />
		��<input type="checkbox" name="color" value="color6" />
		��<input type="checkbox" name="color" value="color7" /><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>