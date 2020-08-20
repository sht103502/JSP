<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modifyProcess" method="POST" name="boardWriteForm" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>글번호</td>
				<td><input type="hidden" name="bnum"value="${boardView.bnum}">${boardView.bnum}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>>${boardView.bdate}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>>${boardView.bhit}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bwriter" size="39"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="bpassword" size="39"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle" size="39"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="40" name="bcontents"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="bfile"></td>
			</tr>
			<tr>
			<td><input type="hidden" name="page" value="${page}"></td>
			<td><input type="submit" value="수정"></td>
			<td><input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>