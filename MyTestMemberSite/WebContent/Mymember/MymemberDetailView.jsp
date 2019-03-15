
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
	<h1>회원정보 수정</h1>
	 <%
	 	MemberDto memberDto = (MemberDto)request.getAttribute("memberDto");
	 %>
	 <form action="./update" method ="post">
	 
	 	
	 		
	 
	<input type="hidden" value="<%=memberDto.getNo()%>" id="no" name ="no">
	회원번호: <%=memberDto.getNo()%><br/>
	이름: <input type="text" value="<%=memberDto.getName()%>"name ="NAME"><br/>
	이메일: <input type="text" value="<%=memberDto.getEmail()%>"name ="EMAIL"><br/>
	비밀번호: <input type="password" value="<%=memberDto.getPasword()%>" name ="PWD"><br/>
	가입일: <%=memberDto.getCreateDate()%><br/>
	<input type="submit" value="수정"> 
	<input type="button" onclick="location.href= './list'" value="뒤로가기"> 
	<input type="button" onclick="location.href= './delete?no=<%=memberDto.getNo()%>'" value="회원탈퇴"> 
	</form>	
	
	<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>