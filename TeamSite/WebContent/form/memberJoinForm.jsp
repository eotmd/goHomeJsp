<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<jsp:include page="./Header.jsp"/>
	
	<h1>회원등록</h1>
	<form action="../member/join" method="post">
		<input type="text" name='name' placeholder="이름"><br>
		<input type="text" name="email" placeholder="이메일"><br>
		<input type="password" name='password' placeholder="비밀번호"><br>
		<input type="submit" value="가입하기">
		<input type="reset" value="취소">
	</form>

	<jsp:include page="./Tail.jsp"/>

</body>
</html>