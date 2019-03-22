<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="./Header.jsp" />
	<br>
	<c:if test="${boardDto.mno != member.mno}">
		<form action="./boardUpdate" method="get">
			<table style="width: 800px; height: 800px;">
				<tr>
					<td colspan="2" style="width: 500px; height: 20px;">제목: ${boardDto.title}</td>
					<td style="margin-right: 0px; width: 300px;">작성자(아이디):
						${boardDto.id}</td>
				</tr>
				<tr>
					<td style="text-align: center; width: 50px;">내용:</td>
					<td colspan="2" style="padding: 0px; vertical-align: top; text-align: left;">
						<textarea readonly="readonly" rows="10" cols="30"
							style="width: 745px; height: 780px;">${boardDto.contents}</textarea>
					</td>
				</tr>
			</table>
			<input type="button" value="뒤로가기"
				onclick="location.href ='/TeamSite/main'">
		</form>
	</c:if>
	<c:if test="${boardDto.mno == member.mno}">
		<form action="./boardUpdate" method="get">
			<input type="hidden" name="boardno" value="${boardDto.boardno}">
			<table style="width: 800px; height: 800px;">
				<tr>
					<td colspan="2" style="width: 500px; height: 20px;">제목:
						${boardDto.title}</td>
					<td style="margin-right: 0px; width: 300px;">작성자(아이디): ${boardDto.id}</td>
				</tr>
				<tr>
					<td style="text-align: center; width: 50px;">내용:</td>
					<td colspan="2"
						style="padding: 0px; vertical-align: top; text-align: left;">
						<textarea readonly="readonly" rows="10" cols="30"
							style="width: 745px; height: 780px;">${boardDto.contents}</textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="수정하기"
				onclick="location.href='./boardUpdate'"> <input
				type="button" value="뒤로가기" onclick="location.href ='/TeamSite/main'">
		</form>
		<form action="./boardDelete" method="get">
			<input type="hidden" name="boardno" value="${boardDto.boardno}">
			<input type="submit" value="삭제하기">
		</form>
	</c:if>

	<jsp:include page="./Tail.jsp" />
	</form>
</body>
</html>