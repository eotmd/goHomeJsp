<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table {
		border-collapse: collapse;
	}
	td{
		border: 1px solid black;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	
		<form action="./boarddetail" method="post">
			<table style="width: 800px; height: 800px;">
				<tr>
					<td colspan="2" style="width: 800px; height: 20px;">제목: ${boardDto.title}</td>
				</tr>
				<tr>
					<td style="text-align: center; width: 50px;">내용: </td>
					<td style="padding: 0px; vertical-align: top; text-align: left;" >
						<textarea readonly="readonly" rows="10" cols="30" style="width: 745px; height: 780px;">${boardDto.contents}</textarea>
					</td>
				</tr>
			</table>
		</form>
	
</body>
</html>