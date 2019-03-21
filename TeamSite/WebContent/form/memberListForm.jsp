<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	
	table, tr, td{
		border: 1px solid black;
	}
</style>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="./Header.jsp" />

	<h1>회원목록</h1>
	<div>
		<a href="../member/join">신규 회원</a>
	</div>
	<br />

<!--  var=변수명  items=목록데이터 begin=시작인덱스 end=종료인덱스 -->
	<table>
		<tr>
			<td>번호</td><td>회원이름</td><td>이메일</td><td>가입일</td>
		</tr>
	<c:forEach var="memberDto" items="${memberList}">
		<tr>
			<td>${memberDto.mno}</td>
			<td>
				<a href='../member/modify?mno=${memberDto.mno}'>${memberDto.name}</a>
			</td>
			<td>${memberDto.email}</td>
			<td>${memberDto.createDate}</td>
		</tr>
	</c:forEach>
	</table>

	<jsp:include page="./Tail.jsp" />

</body>
</html>