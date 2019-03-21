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
	table{
		border-collapse: collapse;
		text-align: center;
	}
	td{
		border: 1px solid black; 
	}
	
</style>
<title>Insert title here</title>
</head>
<%
	
// 	ArrayList<BoardDto> boardDto = new ArrayList<BoardDto>();
// 	boardDto = (ArrayList<BoardDto>)request.getAttribute("boardList");
	
	

%>
<body>
	<table>
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>아이디</td>
			<td>작성일</td>
		</tr>
		<c:forEach var="boardDto" items="${boardList}">
		<tr>
			
			<td>${boardDto.boardno}<input type="hidden" name="boardno" value="${boardDto.boardno}"></td>
			<td><a href="./boarddetail?boardno=${boardDto.boardno}">${boardDto.title}</a></td>
			<td>${boardDto.id}</td>
			<td>${boardDto.createDate}</td>
		</tr>
		</c:forEach>
		
	</table>
	<form action="./boardAdd">
		<input type="hidden" name="no" value="${member.mno}">
		<input type="button"; value="글쓰기"; onclick="location.href='./boardAdd'";>
	</form>
</body>
</html>