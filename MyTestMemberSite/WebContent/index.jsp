<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./auth/login">연습 페이지 이동</a><br/>
	
	<p>이메일 검색</p>
	
	<form action="./MyMember/one" method="get">
		이메일: <input type="text" name="email">
		<input type="submit" value="검색">
	</form>
</body>
</html>