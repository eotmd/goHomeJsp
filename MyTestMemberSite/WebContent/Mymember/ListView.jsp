
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
		List<MemberDto> memberList = new ArrayList<MemberDto>();

		memberList = (ArrayList<MemberDto>)request.getAttribute("memberList");
		
		for(MemberDto memberInfo : memberList){
			
		
	%>
	
	
	<%=memberInfo.getNo()%>,
	<a href="./update?no=<%=memberInfo.getNo()%>"><%=memberInfo.getName()%></a>,
	<%=memberInfo.getEmail()%>,
	<%=memberInfo.getPasword()%>,
	생성 날짜: <%=memberInfo.getCreateDate()%>,
	수정 날짜: <%=memberInfo.getModifiedDate()%><a href="./delete?no=<%=memberInfo.getNo() %>">[삭제]</a>
	<br/>
	<%
		}
	%>
<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>