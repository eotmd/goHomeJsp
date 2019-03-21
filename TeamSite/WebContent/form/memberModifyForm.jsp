<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>

<script type="text/javascript">
	function backPageFnc(){
		location.href = './list';
	}
	
	function deleteUserFnc() {
		var idObj = document.getElementById('mno');
		
		var memberMno = idObj.value;
		
		location.href = './delete?mno=' + memberMno;
	}
</script>
</head>



<!--  	MemberDto memberDto = request.getAttribute("") -->
	
<!--  	memberDto.getName(); -->
<%--  	${m.name} --%>


<body>
	
	<jsp:include page="./Header.jsp"/>
	
	<h1>${memberDto.name} 회원정보 조회</h1>
	<form action="../member/modify" method="post">
		번호: <input type="text" id='mno' name="mno" value="${member.mno}"><br>
		이름: <input type="text" name='name' value="${member.name}"><br>
		이메일: <input type="text" name="email" value="${member.email}"><br>
		가입일: ${requestScope.memberDto.createDate}<br>
		<input type="submit" value="수정">
		<input type="button" value="삭제" onclick="deleteUserFnc();">
		<input type="button" value="뒤로가기" onclick="backPageFnc();">
	</form>

	<jsp:include page="./Tail.jsp"/>

</body>

</html>