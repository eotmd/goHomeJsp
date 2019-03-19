
<%@page import="com.tg.liststudy.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript">
	function loginSubmitFnc() {
		var formObj = document.getElementById('loginForm');
		
		var idObj = document.getElementById('email');
		var pwdObj = document.getElementById('pwd');
		var idVal = idObj.value;
		var pwdVal = pwdObj.value;
		var pwdChkVal = document.getElementById('pwdChk').value;

		 if(idVal == ''){
			alert("이메일을 입력하세요");
			return false;
		}
		if(pwdVal == ''){
			alert("비밀번호를 입력하세요");
			return false;
		}
		else if(pwdChkVal != pwdVal){
			alert("비밀번호가 일치하지 않습니다.")
			return false;
		}
		
		formObj.submit();
		
		
		
	}
	
</script>

</head>


<body>
		<% 
			MemberDto memberDto = (MemberDto)session.getAttribute("member");
		%> 
	<h2>사용자 로그인</h2>
	<form action="./login" id="loginForm" method="post">
		이메일: <input type="text" id="email" name="email" ><br/>
		암호: <input type="password" id="pwd" name="password"><br/>
		<input type="button" value="로그인" onclick="loginSubmitFnc();">
	</form>
	<input type="hidden" id="pwdChk" value="<%=memberDto.getPasword()%>">
	
<%-- 	value=<%=memberDto.getEmail()%> --%>
<%-- 	 value=<%=memberDto.getPasword()%> --%>
</body>
</html>