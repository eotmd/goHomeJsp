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
	
	<h1>회원정보</h1>
	<form action="../member/modify" method="post">
		회원번호<br>
		${member.mno} <input type="hidden" id='mno' name="mno" value="${member.mno}"><br><br>
		이름<br>
		<input type="text" name='name' value="${memberDto.name}"><br><br>
		이메일<br>
		<input type="text" name="email" value="${memberDto.email}"><br><br>
		가입일<br>
		${requestScope.memberDto.createDate}<br><br>
		<input type="submit" value="수정">
		<input type="button" value="회원탈퇴" onclick="deleteUserFnc();">
		<input type="button" value="뒤로가기" onclick="backPageFnc();"><br><br>
	</form>

	<jsp:include page="./Tail.jsp"/>

</body>

</html>