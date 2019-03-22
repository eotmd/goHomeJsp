<%@page import="com.study.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
	text-align: center;
	width: 500px;
	height: 30px;
	margin: auto;
}

td {
	border: 1px solid black;
}

html, body {
	width: 99.5%;
	height: 95%;
}

.outer {
	display: table;
	width: 100%;
	height: 100%;
}

.inner {
	display: table-cell;
	vertical-align: top;
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<%
	// 	ArrayList<BoardDto> boardDto = new ArrayList<BoardDto>();
	// 	boardDto = (ArrayList<BoardDto>)request.getAttribute("boardList");
%>
<body>

	<jsp:include page="./Header.jsp" />
	<div class="outer">
		<div class="inner">
		<br>
			<table>
				<tr>
					<td style="width: 60px;">글목록</td>
					<td style="width: 200px;">제목</td>
					<td style="width: 150px;">아이디</td>
					<td style="width: 90px;">작성일</td>
				</tr>
				<c:forEach var="boardDto" items="${boardList}">
					<tr>

						<td>${boardDto.boardno}<input type="hidden" name="boardno"
							value="${boardDto.boardno}"></td>
						<td><a href="./boarddetail?boardno=${boardDto.boardno}">${boardDto.title}</a></td>
						<td>${boardDto.id}</td>
						<td>${boardDto.createDate}</td>
					</tr>
				</c:forEach>

			</table>
			<form action="./boardAdd">
				<input style="" type="hidden" name="no" value="${member.mno}"><br>
				<input type="button" ; value="글쓰기"
					; onclick="location.href='./boardAdd'";>
			</form>
		</div>
	</div>

	<jsp:include page="./Tail.jsp" />
</body>
</html>