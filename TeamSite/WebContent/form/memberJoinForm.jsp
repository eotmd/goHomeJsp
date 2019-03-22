<%@ page import="com.study.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<style type="text/css">
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
<script type="text/javascript">
	function joinPageFnc() {
		location.href = './join';
	}

	function joinSubmitFnc() {
		var formObj = document.getElementById('joinForm');
		var checkObj = document.getElementById('check');

		var nameObj = document.getElementById('name');

		if (nameObj.value == '') {
			alert("이름을 입력해 주세요.");
			return false;
		}

		var emailObj = document.getElementById('email');

		if (emailObj.value == '') {
			alert("이메일을 입력해 주세요.");
			return false;
		}

		var passwordObj = document.getElementById('pwd');

		if (passwordObj.value == '') {
			alert("암호를 입력해 주세요.");
			return false;
		}

		formObj.submit();
	}
</script>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	<div class="outer">
		<div class="inner">
			<h1>회원가입</h1>
			<form action="../member/join" id="joinForm" method="post">
				<input type="text" id='name' name='name' placeholder="이름"><br>
				<br> <input type="text" id='email' name="email"
					placeholder="이메일"><br>
				<br> <input type="password" id='pwd' name='password'
					placeholder="비밀번호"><br>
				<br> <input type="button" value="가입하기"
					onclick="joinSubmitFnc();"> <input type="reset" value="취소"><br>
				<br> <input type="hidden" id="check" value="${member.email}">
			</form>
		</div>
	</div>

	<jsp:include page="./Tail.jsp" />

</body>
</html>