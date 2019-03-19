
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.tg.liststudy.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
	<h1>회원목록</h1>

	<div>
		<a href="./add">신규회원</a>
	</div>
	<br />

	<%
		
		MemberDto memberDto = (MemberDto)request.getAttribute("memberDto");
		
		
	%>
	
	<table>
		<tr>
			<td><%=memberDto.getNo()%></td>
			<td><%=memberDto.getName()%></td>
			<td><%=memberDto.getEmail()%></td>
			<td><%=memberDto.getCreateDate()%></td>
		</tr>
	</table>
	
	
	<br/>
	
<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>