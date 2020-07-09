<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	text-align: center;
}
</style>
</head>
<body>
	<h1>좋아하는 사진을 선택하세요</h1>
	<form action="CheckServlet" method="GET">
		<table>
			<tr>
				<td><img src="image/a1.png" width="200px"/></td>
				<td><img src="image/a2.png" width="200px"/></td>
				<td><img src="image/a3.png" width="200px"/></td>
				<td><img src="image/a4.png" width="200px"/></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="pick" value="a1.png">1번사진</td>
				<td><input type="checkbox" name="pick" value="a2.png">2번사진</td>
				<td><input type="checkbox" name="pick" value="a3.png">3번사진</td>
				<td><input type="checkbox" name="pick" value="a4.png">4번사진</td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="선택" /></td>
			</tr>
		</table>

	</form>
</body>
</html>