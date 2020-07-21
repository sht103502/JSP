<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BoardWrite.jsp</h1>
	<form action="boardWriteFile" method="POST" 
	name="boardWriteForm" enctype="multipart/form-data">
		<!-- enctype="multipart /form-data"는 request.getparameter로 받지 못함 -->
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bWriter" id="bWriter" size="39"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="bPassword" id="bPassword"
					size="39"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" id="bTitle" size="39"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="40" name="bContent" id="bContent"></textarea></td>
			</tr>
			<tr>
			<td>첨부파일</td>
			<td><input type="file" name="bFile"></td>
			</tr>
		</table>

	</form>
	<button onclick="boardWrite()">글등록</button>
	<button onclick="location.href='pagingList'">목록</button>
</body>
<script>
	function boardWrite() {
		boardWriteForm.submit();
	}
</script>
</html>