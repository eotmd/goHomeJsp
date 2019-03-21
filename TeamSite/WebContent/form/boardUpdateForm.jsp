<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./boardUpdate" method="post">
		<input type="hidden" name="boardno" value="${boardDto.boardno}">
			<table style="width: 800px; height: 800px;">
				<tr>
					<td style="width: 50px; height: 20px;">제목: </td>
					<td><input type="text" name="title" value="${boardDto.title}" style="width: 740px; height: 20px;"> </td>
				</tr>
				<tr>
					<td style="text-align: center; width: 50px;">내용: </td>
					<td style="padding: 0px; vertical-align: top; text-align: left;" >
						<textarea name="contents" rows="10" cols="30" style="width: 745px; height: 780px;">${boardDto.contents}</textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="수정완료">
			<input type="reset" value="지우개">
			<input type="button" value="뒤로가기" onclick="location.href ='./boarddetail?boardno=${boardDto.boardno}'">
	</form>
	
		
</body>
</html>