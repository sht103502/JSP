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
			<th>작성자</th>
			<th>비밀번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th>기능</th>
		</tr>
		<!--ListController에서  if(ctrlList != null) {
			request.setAttribute("jspList", ctrlList); 여기에 해당함-->
		<!--검색경과 (갯수)만큼 반복해서 출력된다.  -->
		<tr>
			<td>${boardView.bWriter}</td>
			<td>${boardView.bPassword}</td>
			<td>${boardView.bTitle}</td>
			<td>${boardView.bContent}</td>
			<td>${boardView.bDate}</td>
			<td><a href="boardModify?bTitle=${boardList.bTitle}">수정</a></td>


		</tr>



	</table>
</body>
</html>