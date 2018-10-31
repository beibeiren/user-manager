<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="com.training.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Test EL 表达式</title>
</head>
<body>
	EL表达式-运算符:<br>
	1+1= ${1+1} <br>
	2-2= ${2-2} <br>
	3*3= ${3*3} <br>
	4/4= ${4/4} <br>
	5%5= ${5%5} <br>
	14 == 15 ${14==15} <br>
	!(14 == 15) ${!(14==15)} <br>
	---------------------------------------<br>
	EL表达式-请求参数:<br>
	
	1. Java脚本方式获取请求参数：<br>
	request.getParameter("name") = <%= request.getParameter("name")%> <br>
	request.getParameter("password") = <%= request.getParameter("password")%> <br>
	<%
	String[] colors = request.getParameterValues("color") == null ? new String[]{}: request.getParameterValues("color");
	String color = "";
	for(int i=0; i<colors.length; i++) {
		color += colors[i] + ",";
	}
	out.println("checkbox值: " + color);
	%>
	<br>
	2. EL表达式获取请求参数：<br>
	param.name = ${param.name} <br>
	param[name] = ${param['name']} <br>
	param.password = ${param.password}<br>
	checkbox值: ${paramValues.color[0]} ,${paramValues.color[1]} <br>
	---------------------------------------<br>
	EL表达式作用范围:<br>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue");
		session.setAttribute("sessionName", "sessionValue");
		application.setAttribute("applicationName", "applicationValue");
	%>
	<%=pageContext.getAttribute("pageName") %> == ${pageScope.pageName}<br>
	<%=request.getAttribute("requestName") %> == ${requestScope.requestName}<br>
	<%=session.getAttribute("sessionName") %> == ${sessionScope.sessionName}<br>
	<%=application.getAttribute("applicationName") %> == ${applicationScope.applicationName}<br>
	---------------------------------------<br>
	EL表达式-对象：<br>
	<% 
		Teacher teacher = new Teacher("John", 30); 
		Student student = new Student("Tom", 15, teacher);
		request.setAttribute("student", student);
	%>
	1. 获取对象属性值:<br>
	${requestScope.student.name}
	${requestScope.student.age}
	${requestScope.student.teacher.name}
	${requestScope.student.teacher.age} <br>
	2. 执行对象方法:<br>
	${requestScope.student.study()} <br>
	---------------------------------------<br>
	
	请求参数字符串                                 ${pageContext.request.queryString} <br>
	请求URL不包括参数字符串              ${pageContext.request.requestURL}  <br>          
	服务的webApplication的名称    ${pageContext.request.contextPath} <br>	   
	Method  				  ${pageContext.request.method}		 <br>	   
	Protocol				  ${pageContext.request.protocol}    <br>         
	取得用户名称 				  ${pageContext.request.remoteUser}  <br>         
	取得用户IP地址 			  ${pageContext.request.remoteAddr}  <br>         
	<!--判断session是否为新的 	      ${pageContext.session.isNew()}     <br>-->     
	取得sessionId 			  ${pageContext.session.id}          <br>
	取得主机端的服务信息                    ${pageContext.servletContext.serverInfo}<br>
	     
</body>
</html>