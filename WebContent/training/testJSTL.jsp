<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.training.entity.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>test JSTL ��ǩ</title>
</head>
<body>
	1. ������� c:set<br>
	2. �������ֵ�� c:out
	[request scope]:<br>
	<c:set var="requestName" value="Tom" scope="request"></c:set>
	JSTL���ʽ�� <c:out value="${requestName}"></c:out><br>
	EL���ʽ��    ${requestScope.requestName}   <br><br>
	[session scope]:<br>
	<c:set var="sessionName" value="John" scope="session"></c:set>
	JSTL���ʽ�� <c:out value="${sessionName}"></c:out><br>
	EL���ʽ��    ${sessionScope.sessionName}  <br><br>
	[page scope]:<br>
	<c:set var="pageName" value="Karl" scope="page"></c:set>
	JSTL���ʽ�� <c:out value="${pageName}"></c:out><br>
	EL���ʽ��    ${pageScope.pageName}   <br><br>
	[application scope]:<br>
	<c:set var="applicationName" value="Isabella" scope="application"></c:set>
	JSTL���ʽ�� <c:out value="${applicationName}"></c:out><br>
	EL���ʽ��    ${applicationScope.applicationName}  <br><br>
	
	3. ɾ������ֵ c:remove<br>
	<c:remove var="requestName"/>
	JSTL���ʽ�� <c:out value="${requestName}"></c:out><br>
	EL���ʽ��    ${requestScope.requestName}   <br><br>
	
	4. �����ж� c:if<br>
	<c:if test="${empty sessionScope.sessionName}" var="result">
		name is null
	</c:if>
	<c:if test="${!result}">
		name is not null
	</c:if><br><br>
	
	5. c:choose c:when c:otherwise <br>
	<c:set var="money" value="999"></c:set>
	<c:choose>
		<c:when test="${money>=1000}">
			���ţ� ���!
		</c:when>
		<c:when test="${money<1000 && money >=100}">
			ûǮ�����
		</c:when>
		<c:otherwise>
			������
		</c:otherwise>
	</c:choose>
	<br><br>
	
	6. foreachѭ��<br>
	<c:forEach begin="0" end="10" varStatus="status" step="2">
		index = ${status.index} , count=${status.count} <br>
	</c:forEach>	
	<br>
	<%
		List<Student> students = new ArrayList<Student>();
		Student stu1 = new Student("Carry", 21, null);
		students.add(stu1);
		Student stu2 = new Student("John", 22, null);
		students.add(stu2);
		Student stu3 = new Student("Tom", 23, null);
		students.add(stu3);
		request.setAttribute("students", students);
	%>
	
	<c:forEach items="${requestScope.students}" var="stu" varStatus="status">
		${status.count}, name=${stu.name} , age=${stu.age}<br>
	</c:forEach>	
	
	
	
</body>
</html>