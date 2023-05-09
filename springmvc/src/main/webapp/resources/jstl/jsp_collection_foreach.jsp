<%@page import="kr.multi.erp.member.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>컬렉션에 저장된 데이터에 접근하기(가장많이 사용된다.)</h1>
	<h2>jsp가 하는일은 컨트롤러에서 공유한 attribute를 꺼내서 출력 - 컨트롤러에서 공유된 값</h2>
	<h2>1. 배열데이터(JSP에서 만들어진 값)</h2>
	<%
	String[] arr = { "jsp", "java", "spring", "servlet" };
	%>
	<c:forEach var="data" items="<%=arr%>">
		<h3>${data }</h3>
	</c:forEach>

	<h2>2. ArrayList(컨트롤러에서 공유된 데이터)</h2>
	<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("하둡");
	list.add("몽고디비");
	list.add("스파크");
	list.add("피그");
	request.setAttribute("list", list);
	%>

	<c:forEach var="data" items="<%=list%>">
		<h3>${data }</h3>
	</c:forEach>

	<h2>3. ArrayList 저장된DTD제어</h2>
	<%
	ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
	userlist.add(new EmpDTO("001","장동건","","","",""));
	userlist.add(new EmpDTO("001","이민호","","","",""));
	userlist.add(new EmpDTO("001","홍길동","","","",""));
	userlist.add(new EmpDTO("001","방탄소년단","","","",""));
	request.setAttribute("userlist", userlist);
	%>
	<!-- 공유된 어트리뷰트 userlist에 저장된 dto에서 name꺼내서 출력하기 -->
	<c:forEach var="user" items="${userlist}">
		<h3>${user.name}</h3>
	</c:forEach>
	
</body>


</html>