<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>제목</th>
			<td>${boardView.bTitle}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardView.bWriter}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardView.bContent}</td>
		</tr>
		<tr>
			<th>파일</th>
			<td><img src="fileUpload/${boardView.bFile}" width="200"><br />${boardView.bFile}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardView.bHit}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${boardView.bDate}</td>
		</tr>
		<tr>
			<td>
			<button onclick="location.href='pagingList'">목록</button>
			<button onclick="BoardModify()">수정</button>
			<button onclick="BoardDelete()">삭제</button>
			</td>
		</tr>	
	</table>

	<button onclick="BoardPassword()">비밀번호 확인</button>

</body>
<script>
	function BoardPassword() {
		var passConfirm = prompt('비밀번호를 입력하세요');
		var password = ${boardView.bPassword};
		if (passConfirm == password) {
			alert('비밀번호가 일치합니다.');
		} else {
			alert('비밀번호 불일치합니다');
		}
	}
	function BoardModify() {
		var passConfirm = prompt('비밀번호를 입력하세요');
		var password = ${boardView.bPassword};
		if (passConfirm == password) {
			alert('비밀번호 일치합니다.');
			location.href="BoardModify.jsp?bNum=${boardView.bNum}&bTitle=${boardView.bTitle}&bWriter=${boardView.bWriter}"
		} else {
			alert('비밀번호가 불일치합니다.');
		}
	}
	
	function BoardDelete() {
		var passConfirm = prompt('비밀번호를 입력하세요');
		var password = ${boardVeiw.bPassword};
		if (passConfirm == password) {
			alert('비밀번호가 일치합니다.');
			location.href = 'boardDelete?bNum=${boardView.bNum}';
		} else {
			alert('비밀번호가 불일치합니다.');
		}
	}
</script>
</html>