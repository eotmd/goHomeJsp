<%@ page import="com.study.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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

	function loginSubmitFnc() {
		var formObj = document.getElementById('loginForm');

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

<%
	MemberDto memberDto = (MemberDto) session.getAttribute("member");
	if (memberDto == null) {
		System.out.println("세션에 회원 정보가 없습니다.");
	} else {
		System.out.println(memberDto.getEmail());
		System.out.println("님의 정보가 존재합니다");

		// 		String contextPathStr = request.getContextPath() + "/member/list";

		// 		response.sendRedirect(contextPathStr);
	}
%>

<body>
	<jsp:include page="./Header.jsp" />
		<div class="outer">
			<div class="inner">
					
					<h2>로그인</h2>
					<form action="../member/login" id="loginForm" method="post">
						<input type="text" id='email' name="email" placeholder="이메일"><br>
						<br> <input type="password" id='pwd' name="password"
							placeholder="비밀번호"><br>
						<br> <input type="button" value="로그인"
							onclick="loginSubmitFnc();"> <input type="button"
							value="회원가입" onclick="joinPageFnc();">
							<input type="button" onclick="location.href ='/TeamSite/main'" value="뒤로가기"><br>
						<br>
					</form>
			</div>
	</div>
	<jsp:include page="./Tail.jsp" />

</body>
</html>