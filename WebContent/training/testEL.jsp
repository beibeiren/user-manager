<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="com.training.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Test EL ���ʽ</title>
</head>
<body>
	EL���ʽ-�����:<br>
	1+1= ${1+1} <br>
	2-2= ${2-2} <br>
	3*3= ${3*3} <br>
	4/4= ${4/4} <br>
	5%5= ${5%5} <br>
	14 == 15 ${14==15} <br>
	!(14 == 15) ${!(14==15)} <br>
	---------------------------------------<br>
	EL���ʽ-�������:<br>
	
	1. Java�ű���ʽ��ȡ���������<br>
	request.getParameter("name") = <%= request.getParameter("name")%> <br>
	request.getParameter("password") = <%= request.getParameter("password")%> <br>
	<%
	String[] colors = request.getParameterValues("color") == null ? new String[]{}: request.getParameterValues("color");
	String color = "";
	for(int i=0; i<colors.length; i++) {
		color += colors[i] + ",";
	}
	out.println("checkboxֵ: " + color);
	%>
	<br>
	2. EL���ʽ��ȡ���������<br>
	param.name = ${param.name} <br>
	param[name] = ${param['name']} <br>
	param.password = ${param.password}<br>
	checkboxֵ: ${paramValues.color[0]} ,${paramValues.color[1]} <br>
	---------------------------------------<br>
	EL���ʽ���÷�Χ:<br>
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
	EL���ʽ-����<br>
	<% 
		Teacher teacher = new Teacher("John", 30); 
		Student student = new Student("Tom", 15, teacher);
		request.setAttribute("student", student);
	%>
	1. ��ȡ��������ֵ:<br>
	${requestScope.student.name}
	${requestScope.student.age}
	${requestScope.student.teacher.name}
	${requestScope.student.teacher.age} <br>
	2. ִ�ж��󷽷�:<br>
	${requestScope.student.study()} <br>
	---------------------------------------<br>
	
	��������ַ���                                 ${pageContext.request.queryString} <br>
	����URL�����������ַ���              ${pageContext.request.requestURL}  <br>          
	�����webApplication������    ${pageContext.request.contextPath} <br>	   
	Method  				  ${pageContext.request.method}		 <br>	   
	Protocol				  ${pageContext.request.protocol}    <br>         
	ȡ���û����� 				  ${pageContext.request.remoteUser}  <br>         
	ȡ���û�IP��ַ 			  ${pageContext.request.remoteAddr}  <br>         
	<!--�ж�session�Ƿ�Ϊ�µ� 	      ${pageContext.session.isNew()}     <br>-->     
	ȡ��sessionId 			  ${pageContext.session.id}          <br>
	ȡ�������˵ķ�����Ϣ                    ${pageContext.servletContext.serverInfo}<br>
	     
</body>
</html>