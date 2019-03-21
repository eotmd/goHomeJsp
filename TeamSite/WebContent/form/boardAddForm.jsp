<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../boardAdd" method="post">
		<input type="hidden" name="mno" value="${member.mno}">
			<table style="width: 800px; height: 800px;">
				<tr>
					<td style="width: 50px; height: 20px; text-align: right;">제목: </td>
					<td>
						<input name="title" type="text" maxlength="30" style="width: 740px;">
					</td>
				</tr>
				<tr>
					<td style="text-align: center; width: 50px; text-align: right;">내용: </td>
					<td style="padding: 0px; vertical-align: top; text-align: left;" >
						<textarea name="contents" style="width: 740px; height: 780px;" maxlength="2800"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="완료">
			<input type="reset" value="지우기">
			<input type="button" value="뒤로가기" onclick="location.href ='../main'">
		</form>
</body>
</html>