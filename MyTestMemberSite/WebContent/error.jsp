<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템 오류</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
	<%
		Exception e = (Exception)request.getAttribute("error");
		String msg ="";
		msg = e.getMessage();
		
	%>
	<p>
		요청을 처리하는 중에 문제가 발생하였습니다. 잠시 후에 다시 요청하시기 바랍니다.
		만약 계속해서 이 문제가 발행된다면 시스템 운영팀(사내번호: 8282)에 연락하기 바랍니다.
	</p>
	메세지: <%=msg%><br/>
	
	<input type="button" onclick= "location.href= './list'" value="뒤로가기">
	
<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>