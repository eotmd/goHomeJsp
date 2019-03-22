<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addFnc() {
		var formObj = document.getElementById("formid");
		var titleObj = document.getElementById("titleid");
		var contentsObj = document.getElementById("contentsid");
		
		if(titleObj.value == ''){
			alert("제목을 입력해 주세요!")
			return false;
		}
		if(contentsObj.value == ''){
			alert("내용을 입력해 주세요!")
			return false;
		}
		
		formObj.submit();
		
	}

</script>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	<form id="formid" action="../boardAdd" method="post">
		<input type="hidden" name="mno" value="${member.mno}">
		<table style="width: 800px; height: 800px;">
			<tr>
				<td id="titleid" style="width: 50px; height: 20px; text-align: right;">제목:</td>
				<td><input name="title" type="text" maxlength="30"
					style="width: 740px;"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 50px; text-align: right;">내용:
				</td>
				<td style="padding: 0px; vertical-align: top; text-align: left;">
					<textarea id="contentsid" name="contents" style="width: 740px; height: 780px;"
						maxlength="2800"></textarea>
				</td>
			</tr>
		</table>
		<input type="button" value="완료" onclick="addFnc();"> <input type="reset"
			value="지우기"> <input type="button" value="뒤로가기"
			onclick="location.href ='../main'">
	</form>
	<jsp:include page="./Tail.jsp" />
</body>
</html>